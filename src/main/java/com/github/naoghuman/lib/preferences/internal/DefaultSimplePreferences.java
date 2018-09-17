/**
 * Copyright (C) 2014 - 2018 Naoghuman
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
package com.github.naoghuman.lib.preferences.internal;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.SimplePreferences;
import java.io.File;
import java.util.prefs.Preferences;

/**
 * The {@code Implementation} from the {@code Interface} 
 * {@link com.github.naoghuman.lib.preferences.core.SimplePreferences}.
 * <p>
 * Access to this {@code Class} is over the facade {@link com.github.naoghuman.lib.preferences.core.PreferencesFacade}.
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.preferences.core.SimplePreferences
 * @see com.github.naoghuman.lib.preferences.core.PreferencesFacade
 */
@Deprecated
public class DefaultSimplePreferences implements SimplePreferences {
    
    private static DefaultPreferencesProvider PREFS_IMPL = null;
    
    @Override
    @Deprecated
    public Preferences forApplication() {
        return PREFS_IMPL.preferencesForModule(this.getClass());
    }

    @Override
    @Deprecated
    public Preferences forModule(Class clazz) {
        return PREFS_IMPL.preferencesForModule(clazz);
    }

    @Override
    @Deprecated
    public Boolean getBoolean(String key, Boolean def) {
        final Boolean value = this.forApplication().getBoolean(key, def);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Load " + key + "=%b", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public Boolean getBoolean(Class clazz, String key, Boolean def) {
        final Boolean b = this.forModule(clazz).getBoolean(key, def);
        
        LoggerFacade.getDefault().own(clazz, String.format("Load " + key + "=%b", b));// NOI18N
        
        return b;
    }

    @Override
    @Deprecated
    public void putBoolean(String key, Boolean value) {
        this.forApplication().putBoolean(key, value);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Save " + key + "=%b", value)); // NOI18N
    }

    @Override
    @Deprecated
    public void putBoolean(Class clazz, String key, Boolean value) {
        this.forModule(clazz).putBoolean(key, value);
        
        LoggerFacade.getDefault().own(clazz, String.format("Save " + key + "=%b", value)); // NOI18N
    }

    @Override
    @Deprecated
    public String get(String key, String def) {
        final String value = this.forApplication().get(key, def);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public String get(Class clazz, String key, String def) {
        final String value = this.forModule(clazz).get(key, def);
        
        LoggerFacade.getDefault().own(clazz, String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public void put(String key, String value) {
        this.forApplication().put(key, value);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Save " + key + "=%s", value)); // NOI18N
    }

    @Override
    @Deprecated
    public void put(Class clazz, String key, String value) {
        this.forModule(clazz).put(key, value);
        
        LoggerFacade.getDefault().own(clazz, String.format("Save " + key + "=%s", value)); // NOI18N
    }

    @Override
    @Deprecated
    public Double getDouble(String key, Double def) {
        final Double value = this.forApplication().getDouble(key, def);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Load " + key + "=%s", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public Double getDouble(Class clazz, String key, Double def) {
        final Double value = this.forModule(clazz).getDouble(key, def);
        
        LoggerFacade.getDefault().own(clazz, String.format("Load " + key + "=%f", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public void putDouble(String key, Double value) {
        this.forApplication().putDouble(key, value);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Save " + key + "=%f", value)); // NOI18N
    }

    @Override
    @Deprecated
    public void putDouble(Class clazz, String key, Double value) {
        this.forModule(clazz).putDouble(key, value);
        
        LoggerFacade.getDefault().own(clazz, String.format("Save " + key + "=%f", value)); // NOI18N
    }

    @Override
    @Deprecated
    public Integer getInt(String key, Integer def) {
        final Integer value = this.forApplication().getInt(key, def);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public Integer getInt(Class clazz, String key, Integer def) {
        final Integer value = this.forModule(clazz).getInt(key, def);
        
        LoggerFacade.getDefault().own(clazz, String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public void putInt(String key, Integer value) {
        this.forApplication().putInt(key, value);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    @Deprecated
    public void putInt(Class clazz, String key, Integer value) {
        this.forModule(clazz).putInt(key, value);
        
        LoggerFacade.getDefault().own(clazz, String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    @Deprecated
    public Long getLong(String key, Long def) {
        final Long value = this.forApplication().getLong(key, def);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public Long getLong(Class clazz, String key, Long def) {
        final Long value = this.forModule(clazz).getLong(key, def);
        
        LoggerFacade.getDefault().own(clazz, String.format("Load " + key + "=%d", value));// NOI18N
        
        return value;
    }

    @Override
    @Deprecated
    public void putLong(String key, Long value) {
        this.forApplication().putLong(key, value);
        
        LoggerFacade.getDefault().own(this.getClass(), String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    @Deprecated
    public void putLong(Class clazz, String key, Long value) {
        this.forModule(clazz).putLong(key, value);
        
        LoggerFacade.getDefault().own(clazz, String.format("Save " + key + "=%d", value)); // NOI18N
    }

    @Override
    @Deprecated
    public void init(boolean drop) {
        if (drop) {
            final String path = System.getProperty("user.dir") + File.separator // NOI18N
                    + SimplePreferences.SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE;
            final File file = new File(path);
            if (file.exists()) {
                LoggerFacade.getDefault().own(this.getClass(), "  Delete file Preferences.properties"); // NOI18N
                
                file.delete();
            }
        }
        
        LoggerFacade.getDefault().debug(this.getClass(), "  Init preferences file"); // NOI18N
        
        System.setProperty(SimplePreferences.SYSTEM_PREFERENCES__FILE,
                SimplePreferences.SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE);
        
        PREFS_IMPL = new DefaultPreferencesProvider() {

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
    
    @Deprecated
    interface DefaultPreferencesProvider {

        /**
         * Returns user preference node. {@link Preferences#absolutePath} of such
         * a node depends whether class provided as a parameter was loaded as a
         * part of any module or not. If so, then absolute path corresponds to 
         * slashified code name base of module.
         * <p>
         * If not, then absolute path corresponds to class's package.
         *
         * @param  clazz the class for which a user preference node is desired.
         * @return the user preference node
         */
        @Deprecated
        Preferences preferencesForModule(final Class clazz);

        /**
         * Returns the root preference node.
         *
         * @return the root preference node.
         */
        @Deprecated
        Preferences preferencesRoot();
    }
    
}
