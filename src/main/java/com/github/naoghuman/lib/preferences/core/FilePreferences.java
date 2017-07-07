/*
 * Copyright (C) 2014 PRo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.preferences.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Preferences implementation that stores to a user-defined file. See also
 * http://www.davidc.net/programming/java/java-preferences-using-file-backing-store
 *
 * @author David Croft (<a href="http://www.davidc.net">www.davidc.net</a>)
 * @version $Id: FilePreferences.java 283 2009-06-18 17:06:58Z david $
 */
public final class FilePreferences extends AbstractPreferences {
    private static final Logger log = Logger.getLogger(FilePreferences.class.getName());
    private static FilePreferences instance = null;
    private static File preferencesFile = null;

    public static Preferences getUserRoot() {
        if (instance == null) {
            instance = new FilePreferences();
        }

        return instance;
    }

    public static Preferences userNodeForPackage(final Class clazz) {
        return FilePreferences.getUserRoot().node(FilePreferences.nodeName(clazz));
    }

    /**
     * Returns the absolute path name of the node corresponding to the package
     * of the specified object.
     *
     * @throws IllegalArgumentException if the package has node preferences node
     * associated with it.
     */
    private static String nodeName(final Class clazz) {
        if (clazz.isArray()) {
            throw new IllegalArgumentException(
                    "Arrays have no associated preferences node."); // NOI18N
        }

        String className = clazz.getName();
        int pkgEndIndex = className.lastIndexOf('.');
        if (pkgEndIndex < 0) {
            return "/<unnamed>"; // NOI18N
        }
        String packageName = className.substring(0, pkgEndIndex);

        return "/" + packageName.replace('.', '/'); // NOI18N
    }
    
    private boolean isRemoved = Boolean.FALSE;
    private Map<String, String> root = null;
    private Map<String, FilePreferences> children = null;

    private FilePreferences() {
        this(null, "");
    }

    private FilePreferences(final AbstractPreferences parent, final String name) {
        super(parent, name);

        log.finest(String.format("Instantiating node %s", name)); // NOI18N

        root = new TreeMap<>();
        children = new TreeMap<>();

        try {
            this.sync();
        } catch (BackingStoreException e) {
            log.log(Level.SEVERE, "Unable to sync on creation of node " + name, e); // NOI18N
        }
    }

    @Override
    protected final void putSpi(final String key, final String value) {
        root.put(key, value);
        try {
            this.flush();
        } catch (BackingStoreException e) {
            log.log(Level.SEVERE, "Unable to flush after putting " + key, e); // NOI18N
        }
    }

    @Override
    protected final String getSpi(final String key) {
        return root.get(key);
    }

    @Override
    protected final void removeSpi(final String key) {
        root.remove(key);
        try {
            this.flush();
        } catch (BackingStoreException e) {
            log.log(Level.SEVERE, "Unable to flush after removing " + key, e); // NOI18N
        }
    }

    @Override
    protected final void removeNodeSpi() throws BackingStoreException {
        isRemoved = true;

        this.flush();
    }

    @Override
    protected final String[] keysSpi() throws BackingStoreException {
        return root.keySet().toArray(new String[root.keySet().size()]);
    }

    @Override
    protected final String[] childrenNamesSpi() throws BackingStoreException {
        return children.keySet().toArray(new String[children.keySet().size()]);
    }

    @Override
    protected final FilePreferences childSpi(final String name) {
        FilePreferences child = children.get(name);
        if (child == null || child.isRemoved()) {
            child = new FilePreferences(this, name);
            children.put(name, child);
        }

        return child;
    }

    @Override
    protected final void syncSpi() throws BackingStoreException {
        if (isRemoved()) {
            return;
        }

        final File file = FilePreferences.getPreferencesFile();
        if (!file.exists()) {
            return;
        }

        synchronized (file) {
            final Properties p = new Properties();
            try {
                p.load(new FileInputStream(file));

                final StringBuilder sb = new StringBuilder();
                this.getPath(sb);

                final String path = sb.toString();
                final Enumeration<?> pnen = p.propertyNames();
                while (pnen.hasMoreElements()) {
                    final String propKey = (String) pnen.nextElement();
                    if (propKey.startsWith(path)) {
                        final String subKey = propKey.substring(path.length());
                        // Only load immediate descendants
                        if (subKey.indexOf('.') == -1) {
                            root.put(subKey, p.getProperty(propKey));
                        }
                    }
                }
            } catch (IOException e) {
                throw new BackingStoreException(e);
            }
        }
    }

    public static File getPreferencesFile() {
        if (preferencesFile == null) {
            String prefsFile = System.getProperty(SimplePreferences.SYSTEM_PREFERENCES__FILE);
            if (prefsFile == null || prefsFile.length() == 0) {
                prefsFile = System.getProperty("user.dir") + File.separator + ".fileprefs"; // NOI18N
            }
            
            preferencesFile = new File(prefsFile).getAbsoluteFile();

            log.finer(String.format("Preferences file is %s", preferencesFile)); // NOI18N
        }

        return preferencesFile;
    }

    private void getPath(final StringBuilder sb) {
        final FilePreferences parent = (FilePreferences) parent();
        if (parent == null) {
            return;
        }

        parent.getPath(sb);
        sb.append(name()).append('.');
    }

    @Override
    protected final void flushSpi() throws BackingStoreException {
        final File file = FilePreferences.getPreferencesFile();

        synchronized (file) {
            final Properties properties = new Properties();
            try {
                final StringBuilder sb = new StringBuilder();
                this.getPath(sb);
                final String path = sb.toString();

                if (file.exists()) {
                    properties.load(new FileInputStream(file));

                    final List<String> toRemove = new ArrayList<>();

                    // Make a list of all direct children of this node to be removed
                    final Enumeration<?> pnen = properties.propertyNames();
                    while (pnen.hasMoreElements()) {
                        final String propKey = (String) pnen.nextElement();
                        if (propKey.startsWith(path)) {
                            final String subKey = propKey.substring(path.length());
                            // Only do immediate descendants
                            if (subKey.indexOf('.') == -1) {
                                toRemove.add(propKey);
                            }
                        }
                    }

                    // Remove them now that the enumeration is done with
                    toRemove.stream()
                            .forEach((propKey) -> {
                                properties.remove(propKey);
                            });
                }

                // If this node hasn't been removed, add back in any values
                if (!isRemoved) {
                    root.keySet().stream()
                            .forEach((s) -> {
                                properties.setProperty(path + s, root.get(s));
                            });
                }

                properties.store(new FileOutputStream(file), "This file is automatically generated. Plz don't modified it manuelly."); // NOI18N
            } catch (IOException e) {
                throw new BackingStoreException(e);
            }
        }
    }
}
