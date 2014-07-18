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
package de.pro.preferences;

import de.pro.logger.api.LoggerFactory;
import de.pro.preferences.api.IPreferences;
import java.io.File;
import java.util.prefs.Preferences;

/**
 *
 * @author PRo
 */
public final class PRoPreferences implements IPreferences {
    
    private static IPreferencesProvider PREFS_IMPL = null;
    
    @Override
    public Preferences forApplication() {
        return PREFS_IMPL.preferencesForModule(this.getClass());
    }

    /**
     * Returns user preference node. {@link Preferences#absolutePath} of such
     * a node depends whether class provided as a parameter was loaded as a part
     * of any module or not. If so, then absolute path corresponds to slashified
     * code name base of module.
     * If not, then absolute path corresponds to class's package.
     *
     * @param clazz the class for which a user preference node is desired.
     * @return the user preference node
     */
    @Override
    public Preferences forModule(Class clazz) {
        return PREFS_IMPL.preferencesForModule(clazz);
    }

    @Override
    public Boolean getBoolean(String key, Boolean def) {
        final Boolean value = this.forApplication().getBoolean(key, def);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Load " + key + "=%b", value));// NOI18N
        
        return value;
    }

    @Override
    public Boolean getBoolean(Class clazz, String key, Boolean def) {
        final Boolean b = this.forModule(clazz).getBoolean(key, def);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Load " + key + "=%b", b));// NOI18N
        
        return b;
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        this.forApplication().putBoolean(key, value);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Save " + key + "=%b", value)); // NOI18N
    }

    @Override
    public void putBoolean(Class clazz, String key, Boolean value) {
        this.forModule(clazz).putBoolean(key, value);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Save " + key + "=%b", value)); // NOI18N
    }

    @Override
    public String get(String key, String def) {
        final String value = this.forApplication().get(key, def);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    public String get(Class clazz, String key, String def) {
        final String value = this.forModule(clazz).get(key, def);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    public void put(String key, String value) {
        this.forApplication().put(key, value);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Save " + key + "=%s", value)); // NOI18N
    }

    @Override
    public void put(Class clazz, String key, String value) {
        this.forModule(clazz).put(key, value);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Save " + key + "=%s", value)); // NOI18N
    }

    @Override
    public Double getDouble(String key, Double def) {
        final Double value = this.forApplication().getDouble(key, def);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    public Double getDouble(Class clazz, String key, Double def) {
        final Double value = this.forModule(clazz).getDouble(key, def);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Load " + key + "=%f", value));// NOI18N
        
        return value;
    }

    @Override
    public void putDouble(String key, Double value) {
        this.forApplication().putDouble(key, value);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Save " + key + "=%f", value)); // NOI18N
    }

    @Override
    public void putDouble(Class clazz, String key, Double value) {
        this.forModule(clazz).putDouble(key, value);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Save " + key + "=%f", value)); // NOI18N
    }

    @Override
    public Integer getInt(String key, Integer def) {
        final Integer value = this.forApplication().getInt(key, def);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    public Integer getInt(Class clazz, String key, Integer def) {
        final Integer value = this.forModule(clazz).getInt(key, def);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    public void putInt(String key, Integer value) {
        this.forApplication().putInt(key, value);
        LoggerFactory.getDefault().debug(this.getClass(),
                String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    public void putInt(Class clazz, String key, Integer value) {
        this.forModule(clazz).putInt(key, value);
        LoggerFactory.getDefault().debug(clazz,
                String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    public void init(Boolean shouldDeletePreferences) {
        LoggerFactory.getDefault().debug(PRoPreferences.class,
                "Init preferences factory and delete preferences file: " + shouldDeletePreferences); // NOI18N
        
        if (shouldDeletePreferences) {
            final String path = System.getProperty("user.dir")
                    + File.separator + "Preferences.properties"; // NOI18N
            final File preferences = new File(path);
            if (preferences.exists()) {
                LoggerFactory.getDefault().debug(PRoPreferences.class,
                        "  Delete file Preferences.properties at program start"); // NOI18N
                preferences.delete();
            }
        }
        
        System.setProperty(
                IPreferences.SYSTEM_PREFERENCES__FILE,
                IPreferences.SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE);
        
        PREFS_IMPL = new IPreferencesProvider() {

            @Override
            public final Preferences preferencesForModule(final Class clazz) {
                return FilePreferences.userNodeForPackage(clazz);
            }

            @Override
            public final Preferences preferencesRoot() {
                return FilePreferences.userRoot();
            }
        };
    }
    
    /**
     * Implementation of {@link PreferencesManager} methods.
     * Not intended for use outside the NetBeans Platform.
     */
    public interface IPreferencesProvider {

        /**
         * Returns user preference node. {@link Preferences#absolutePath} of such
         * a node depends whether class provided as a parameter was loaded as a
         * part of any module or not. If so, then absolute path corresponds to 
         * slashified code name base of module.
         * If not, then absolute path corresponds to class's package.
         *
         * @param clazz the class for which a user preference node is desired.
         * @return the user preference node
         */
        Preferences preferencesForModule(final Class clazz);

        /**
         * Returns the root preference node.
         *
         * @return the root preference node.
         */
        Preferences preferencesRoot();
    }
}
