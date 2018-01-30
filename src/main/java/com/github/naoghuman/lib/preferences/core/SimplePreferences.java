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
package com.github.naoghuman.lib.preferences.core;

import java.util.prefs.Preferences;

/**
 * The {@code Interface} for the default {@code Implementation} 
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences}.
 * <p>
 * Over the facade {@link com.github.naoghuman.lib.preferences.core.PreferencesFacade} 
 * you can access to the default {@code Implementation} for the methods in this 
 * {@code Interface}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.preferences.core.PreferencesFacade
 * @see com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences
 */
public interface SimplePreferences {
    
    /**
     * Key constant for accessing the system preference file.
     */
    public static final String SYSTEM_PREFERENCES__FILE = "SYSTEM_PREFERENCES__FILE"; // NOI18N
    
    /**
     * Default value constant for the system preference file.
     */
    public static final String SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE = "Preferences.properties"; // NOI18N
    
    /**
     * Get a {@link java.lang.Boolean} which is associated with the key in application context.
     * 
     * @param  key The key which value is searched for.
     * @param  def The default value if the key isn't stored.
     * @return The {@code Boolean} which is associated with the key or the default value.
     * @see    java.lang.Boolean
     */
    public Boolean getBoolean(final String key, final Boolean def);
    
    /**
     * Get a {@link java.lang.Boolean} which is associated with the key in module context.
     * 
     * @param  clazz Defined the module context.
     * @param  key   The key which value is searched for.
     * @param  def   The default value if the key isn't stored.
     * @return The {@code Boolean} which is associated with the key or the default value.
     * @see    java.lang.Boolean
     */
    public Boolean getBoolean(final Class clazz, final String key, final Boolean def);
    
    /**
     * Stores a {@link java.lang.Boolean} which is associated with the key in application context.
     * 
     * @param key   The key for the saved {@code Boolean}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Boolean
     */
    public void putBoolean(final String key, final Boolean value);
    
    /**
     * Stores a {@link java.lang.Boolean} which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key   The key for the to saved {@code Boolean}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Boolean
     */
    public void putBoolean(final Class clazz, final String key, final Boolean value);
    
    /**
     * Get a {@link java.lang.String} which is associated with the key in application context.
     * 
     * @param  key The key which value is searched for.
     * @param  def The default value if the key isn't stored.
     * @return The {@code String} which is associated with the key or the default value.
     * @see    java.lang.String
     */
    public String get(final String key, final String def);
    
    /**
     * Get a {@link java.lang.String} which is associated with the key in module context.
     * 
     * @param  clazz Defined the module context.
     * @param  key   The key which value is searched for.
     * @param  def   The default value if the key isn't stored.
     * @return The {@code String} which is associated with the key or the default value.
     * @see    java.lang.String
     */
    public String get(final Class clazz, final String key, final String def);
    
    /**
     * Stores a {@link java.lang.String} which is associated with the key in application context.
     * 
     * @param key   The key for the saved {@code String}.
     * @param value The value which will associated with the key.
     * @see   java.lang.String
     */
    public void put(final String key, final String value);
    
    /**
     * Stores a {@link java.lang.String} which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key   The key for the to saved {@code String}.
     * @param value The value which will associated with the key.
     * @see   java.lang.String
     */
    public void put(final Class clazz, final String key, final String value);
    
    /**
     * Get a {@link java.lang.Double} which is associated with the key in application context.
     * 
     * @param  key The key which value is searched for.
     * @param  def The default value if the key isn't stored.
     * @return The {@code Double} which is associated with the key or the default value.
     * @see    java.lang.Double
     */
    public Double getDouble(final String key, final Double def);
    
    /**
     * Get a {@link java.lang.Double} which is associated with the key in module context.
     * 
     * @param  clazz Defined the module context.
     * @param  key   The key which value is searched for.
     * @param  def   The default value if the key isn't stored.
     * @return The {@code Double} which is associated with the key or the default value.
     * @see    java.lang.Double
     */
    public Double getDouble(final Class clazz, final String key, final Double def);
    
    /**
     * Stores a {@link java.lang.Double} which is associated with the key in application context.
     * 
     * @param key   The key for the saved {@code Double}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Double
     */
    public void putDouble(final String key, final Double value);
    
    /**
     * Stores a {@link java.lang.Double} which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key   The key for the to saved {@code Double}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Double
     */
    public void putDouble(final Class clazz, final String key, final Double value);
    
    /**
     * Get a {@link java.lang.Integer} which is associated with the key in application context.
     * 
     * @param  key The key which value is searched for.
     * @param  def The default value if the key isn't stored.
     * @return The {@code Integer} which is associated with the key or the default value.
     * @see    java.lang.Integer
     */
    public Integer getInt(final String key, final Integer def);
    
    /**
     * Get a {@link java.lang.Integer} which is associated with the key in module context.
     * 
     * @param  clazz Defined the module context.
     * @param  key   The key which value is searched for.
     * @param  def   The default value if the key isn't stored.
     * @return The {@code Integer} which is associated with the key or the default value.
     * @see    java.lang.Integer
     */
    public Integer getInt(final Class clazz, final String key, final Integer def);
    
    /**
     * Stores a {@link java.lang.Integer} which is associated with the key in application context.
     * 
     * @param key   The key for the saved {@code Integer}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Integer
     */
    public void putInt(final String key, final Integer value);
    
    /**
     * Stores a {@link java.lang.Integer} which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key   The key for the to saved {@code Integer}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Integer
     */
    public void putInt(final Class clazz, final String key, final Integer value);
    
    /**
     * Get a {@link java.lang.Long} which is associated with the key in application context.
     * 
     * @param  key The key which value is searched for.
     * @param  def The default value if the key isn't stored.
     * @return The {@code Long} which is associated with the key or the default value.
     * @see    java.lang.Long
     */
    public Long getLong(final String key, final Long def);
    
    /**
     * Get a {@link java.lang.Long} which is associated with the key in module context.
     * 
     * @param  clazz Defined the module context.
     * @param  key   The key which value is searched for.
     * @param  def   The default value if the key isn't stored.
     * @return The {@code Long} which is associated with the key or the default value.
     * @see    java.lang.Long
     */
    public Long getLong(final Class clazz, final String key, final Long def);
    
    /**
     * Stores a {@link java.lang.Long} which is associated with the key in application context.
     * 
     * @param key   The key for the saved {@code Long}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Long
     */
    public void putLong(final String key, final Long value);
    
    /**
     * Stores a {@link java.lang.Long} which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key   The key for the to saved {@code Long}.
     * @param value The value which will associated with the key.
     * @see   java.lang.Long
     */
    public void putLong(final Class clazz, final String key, final Long value);
    
    /**
     * Initialize the {@code Preferences.properties} file.
     * <p>
     * That means that the {@code Preferences.properties} file will created
     * under {@code System.getProperty("user.dir") + File.separator + "Preferences.properties"}.
     * 
     * @param drop Should an existing file dropped at frist?
     */
    public void init(final boolean drop);
    
    /**
     * Allowed access to the {@code Preferences} in application context. You can
     * for example add a {@link java.util.prefs.PreferenceChangeListener} to listen 
     * for changes in specific preferences.
     * 
     * @return The {@code Preferences} in application context.
     * @see    java.util.prefs.PreferenceChangeListener
     */
    public Preferences forApplication();
    
    /**
     * Allowed access to the {@code Preferences} in module context. You can
     * for example add a {@link java.util.prefs.PreferenceChangeListener}
     * to listen for changes in specific preferences.
     * 
     * @param  clazz The class in which defined the module.
     * @return The {@code Preferences} in module context.
     * @see    java.util.prefs.PreferenceChangeListener
     */
    public Preferences forModule(Class clazz);
    
}
