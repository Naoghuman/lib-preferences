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
package de.pro.lib.preferences;

import de.pro.lib.logger.api.LoggerFacade;
import de.pro.lib.preferences.api.ILibPreferences;
import java.io.File;
import java.util.prefs.Preferences;

/**
 * The implementation from the Interface {@link de.pro.lib.preferences.api.ILibPreferences}.<br />
 * Access to this class is over the facade {@link de.pro.lib.preferences.api.PreferencesFacade}.
 * 
 * @author PRo
 * @see de.pro.lib.preferences.api.ILibPreferences
 * @see de.pro.lib.preferences.api.PreferencesFacade
 */
public final class LibPreferences implements ILibPreferences {
    
    private static ILibPreferencesProvider PREFS_IMPL = null;
    
    @Override
    public Preferences forApplication() {
        return PREFS_IMPL.preferencesForModule(this.getClass());
    }

    @Override
    public Preferences forModule(Class clazz) {
        return PREFS_IMPL.preferencesForModule(clazz);
    }

    @Override
    public Boolean getBoolean(String key, Boolean def) {
        final Boolean value = this.forApplication().getBoolean(key, def);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Load " + key + "=%b", value));// NOI18N
        
        return value;
    }

    @Override
    public Boolean getBoolean(Class clazz, String key, Boolean def) {
        final Boolean b = this.forModule(clazz).getBoolean(key, def);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Load " + key + "=%b", b));// NOI18N
        
        return b;
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        this.forApplication().putBoolean(key, value);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Save " + key + "=%b", value)); // NOI18N
    }

    @Override
    public void putBoolean(Class clazz, String key, Boolean value) {
        this.forModule(clazz).putBoolean(key, value);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Save " + key + "=%b", value)); // NOI18N
    }

    @Override
    public String get(String key, String def) {
        final String value = this.forApplication().get(key, def);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    public String get(Class clazz, String key, String def) {
        final String value = this.forModule(clazz).get(key, def);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    public void put(String key, String value) {
        this.forApplication().put(key, value);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Save " + key + "=%s", value)); // NOI18N
    }

    @Override
    public void put(Class clazz, String key, String value) {
        this.forModule(clazz).put(key, value);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Save " + key + "=%s", value)); // NOI18N
    }

    @Override
    public Double getDouble(String key, Double def) {
        final Double value = this.forApplication().getDouble(key, def);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    public Double getDouble(Class clazz, String key, Double def) {
        final Double value = this.forModule(clazz).getDouble(key, def);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Load " + key + "=%f", value));// NOI18N
        
        return value;
    }

    @Override
    public void putDouble(String key, Double value) {
        this.forApplication().putDouble(key, value);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Save " + key + "=%f", value)); // NOI18N
    }

    @Override
    public void putDouble(Class clazz, String key, Double value) {
        this.forModule(clazz).putDouble(key, value);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Save " + key + "=%f", value)); // NOI18N
    }

    @Override
    public Integer getInt(String key, Integer def) {
        final Integer value = this.forApplication().getInt(key, def);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    public Integer getInt(Class clazz, String key, Integer def) {
        final Integer value = this.forModule(clazz).getInt(key, def);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    public void putInt(String key, Integer value) {
        this.forApplication().putInt(key, value);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    public void putInt(Class clazz, String key, Integer value) {
        this.forModule(clazz).putInt(key, value);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    public Long getLong(String key, Long def) {
        final Long value = this.forApplication().getLong(key, def);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    public Long getLong(Class clazz, String key, Long def) {
        final Long value = this.forModule(clazz).getLong(key, def);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    public void putLong(String key, Long value) {
        this.forApplication().putLong(key, value);
        LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    public void putLong(Class clazz, String key, Long value) {
        this.forModule(clazz).putLong(key, value);
        LoggerFacade.INSTANCE.getLogger().own(clazz,
                String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    public void init(boolean drop) {
        if (drop) {
            final String path = System.getProperty("user.dir") + File.separator // NOI18N
                    + ILibPreferences.SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE;
            final File file = new File(path);
            if (file.exists()) {
                LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                    "  Delete file Preferences.properties"); // NOI18N
                
                file.delete();
            }
        }
        
        LoggerFacade.INSTANCE.getLogger().debug(LibPreferences.class, "  Init preferences file"); // NOI18N
        
        System.setProperty(ILibPreferences.SYSTEM_PREFERENCES__FILE,
                ILibPreferences.SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE);
        
        PREFS_IMPL = new ILibPreferencesProvider() {

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
    
    interface ILibPreferencesProvider {

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
