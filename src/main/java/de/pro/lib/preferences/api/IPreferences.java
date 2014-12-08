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
package de.pro.lib.preferences.api;

import java.util.prefs.Preferences;

/**
 * The <code>Interface</code> for the class {@link de.pro.lib.preferences.PRoPreferences}.<br />
 * Over the facade {@link de.pro.lib.preferences.api.PreferencesFacade} you can 
 * access the methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.preferences.PRoPreferences
 * @see de.pro.lib.preferences.api.PreferencesFacade
 */
public interface IPreferences {
    /**
     * Key constant for accessing the system preferfence file.
     */
    public static final String SYSTEM_PREFERENCES__FILE = "SYSTEM_PREFERENCES__FILE"; // NOI18N
    
    /**
     * Default value contant for the system preferfence file.
     */
    public static final String SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE = "Preferences.properties"; // NOI18N
    
    /**
     * Get a <code>Boolean</code> which is associated with the key in application context.
     * 
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>Boolean</code> which is associated with the key or the default value.
     */
    public Boolean getBoolean(String key, Boolean def);
    
    /**
     * Get a <code>Boolean</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>Boolean</code> which is associated with the key or the default value.
     */
    public Boolean getBoolean(Class clazz, String key, Boolean def);
    
    /**
     * Store a <code>Boolean</code> which is associated with the key in application context.
     * 
     * @param key The key for the saved <code>Boolean</code>.
     * @param value The value which will associated with the key.
     */
    public void putBoolean(String key, Boolean value);
    
    /**
     * Store a <code>Boolean</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key for the to saved <code>Boolean</code>.
     * @param value The value which will associated with the key.
     */
    public void putBoolean(Class clazz, String key, Boolean value);
    
    /**
     * Get a <code>String</code> which is associated with the key in application context.
     * 
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>String</code> which is associated with the key or the default value.
     */
    public String get(String key, String def);
    
    /**
     * Get a <code>String</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>String</code> which is associated with the key or the default value.
     */
    public String get(Class clazz, String key, String def);
    
    /**
     * Store a <code>String</code> which is associated with the key in application context.
     * 
     * @param key The key for the saved <code>String</code>.
     * @param value The value which will associated with the key.
     */
    public void put(String key, String value);
    
    /**
     * Store a <code>String</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key for the to saved <code>String</code>.
     * @param value The value which will associated with the key.
     */
    public void put(Class clazz, String key, String value);
    
    /**
     * Get a <code>Double</code> which is associated with the key in application context.
     * 
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>Double</code> which is associated with the key or the default value.
     */
    public Double getDouble( String key, Double def);
    
    /**
     * Get a <code>Double</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>Double</code> which is associated with the key or the default value.
     */
    public Double getDouble(Class clazz, String key, Double def);
    
    /**
     * Store a <code>Double</code> which is associated with the key in application context.
     * 
     * @param key The key for the saved <code>Double</code>.
     * @param value The value which will associated with the key.
     */
    public void putDouble(String key, Double value);
    
    /**
     * Store a <code>Double</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key for the to saved <code>Double</code>.
     * @param value The value which will associated with the key.
     */
    public void putDouble(Class clazz, String key, Double value);
    
    /**
     * Get a <code>Integer</code> which is associated with the key in application context.
     * 
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>Integer</code> which is associated with the key or the default value.
     */
    public Integer getInt(String key, Integer def);
    /**
     * Get a <code>Integer</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key which value is searched for.
     * @param def The default value if the key isn't stored.
     * @return The <code>Integer</code> which is associated with the key or the default value.
     */
    public Integer getInt(Class clazz, String key, Integer def);
    
    /**
     * Store a <code>Integer</code> which is associated with the key in application context.
     * 
     * @param key The key for the saved <code>Integer</code>.
     * @param value The value which will associated with the key.
     */
    public void putInt(String key, Integer value);
    
    /**
     * Store a <code>Integer</code> which is associated with the key in module context.
     * 
     * @param clazz Defined the module context.
     * @param key The key for the to saved <code>Integer</code>.
     * @param value The value which will associated with the key.
     */
    public void putInt(Class clazz, String key, Integer value);
    
    /**
     * Initialize the <code>Preferences.properties</code> file.<br />
     * That means that the <code>Preferences.properties</code> file will created
     * under <code>System.getProperty("user.dir") + File.separator
     * + "Preferences.properties"</code>.
     * 
     * @param drop Should the existing file dropped at frist?
     */
    public void init(boolean drop);
    
    /**
     * Allowed access to the <code>Preferences</code> in application context. You can
     * for example add a {@link java.util.prefs.PreferenceChangeListener PreferenceChangeListener}
     * to listen for changes in specific preferences.
     * 
     * @return The <code>Preferences</code> in application context.
     */
    public Preferences forApplication();
    
    /**
     * Allowed access to the <code>Preferences</code> in module context. You can
     * for example add a {@link java.util.prefs.PreferenceChangeListener PreferenceChangeListener}
     * to listen for changes in specific preferences.
     * 
     * @param clazz The class in which defined the module.
     * @return The <code>Preferences</code> in module context.
     */
    public Preferences forModule(Class clazz);
}
