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
package de.pro.preferences.api;

import java.util.prefs.Preferences;

/**
 * 
 * @author PRo
 */
public interface IPreferences {
    public static final String SYSTEM_PREFERENCES__FILE = "SYSTEM_PREFERENCES__FILE"; // NOI18N
    public static final String SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE = "Preferences.properties"; // NOI18N
    
    public Boolean getBoolean(String key, Boolean def);
    public Boolean getBoolean(Class clazz, String key, Boolean def);
    public void putBoolean(String key, Boolean value);
    public void putBoolean(Class clazz, String key, Boolean value);
    
    public String get(String key, String def);
    public String get(Class clazz, String key, String def);
    public void put(String key, String value);
    public void put(Class clazz, String key, String value);
    
    public Double getDouble( String key, Double def);
    public Double getDouble(Class clazz, String key, Double def);
    public void putDouble(String key, Double value);
    public void putDouble(Class clazz, String key, Double value);
    
    public Integer getInt(String key, Integer def);
    public Integer getInt(Class clazz, String key, Integer def);
    public void putInt(String key, Integer value);
    public void putInt(Class clazz, String key, Integer value);
    
    public void init(Boolean shouldDeletePreferences);
    public Preferences forApplication();
    public Preferences forModule(final Class clazz);
}
