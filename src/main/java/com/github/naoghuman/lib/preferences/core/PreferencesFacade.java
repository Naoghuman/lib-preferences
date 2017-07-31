/**
 * Copyright (C) 2017 Naoghuman
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

import com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences;
import java.util.Optional;
import java.util.prefs.Preferences;

/**
 * The facade {@link com.github.naoghuman.lib.preferences.core.PreferencesFacade} provides 
 * access to the default implementation from the {@code Interface} 
 * {@link com.github.naoghuman.lib.preferences.core.SimplePreferences}.<br>
 * The default implementation from the Interface {@code SimplePreferences} is 
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.preferences.core.SimplePreferences
 * @see com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences
 */
public class PreferencesFacade implements SimplePreferences {
    
    private static final Optional<PreferencesFacade> instance = Optional.of(new PreferencesFacade());

    /**
     * Returns a singleton instance from the class <code>PreferencesFacade</code>.
     * 
     * @return a singleton instance from the class <code>PreferencesFacade</code>.
     */
    public static final PreferencesFacade getDefault() {
        return instance.get();
    }
    
    private SimplePreferences preferences = null;
    
    private PreferencesFacade() {
        this.initialize();
    }
    
    private void initialize() {
        preferences = new DefaultSimplePreferences();
    }

    @Override
    public Boolean getBoolean(String key, Boolean def) {
        return preferences.getBoolean(key, def);
    }

    @Override
    public Boolean getBoolean(Class clazz, String key, Boolean def) {
        return preferences.getBoolean(clazz, key, def);
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        preferences.putBoolean(key, value);
    }

    @Override
    public void putBoolean(Class clazz, String key, Boolean value) {
        preferences.putBoolean(clazz, key, value);
    }

    @Override
    public String get(String key, String def) {
        return preferences.get(key, def);
    }

    @Override
    public String get(Class clazz, String key, String def) {
        return preferences.get(clazz, key, def);
    }

    @Override
    public void put(String key, String value) {
        preferences.put(key, value);
    }

    @Override
    public void put(Class clazz, String key, String value) {
        preferences.put(clazz, key, value);
    }

    @Override
    public Double getDouble(String key, Double def) {
        return preferences.getDouble(key, def);
    }

    @Override
    public Double getDouble(Class clazz, String key, Double def) {
        return preferences.getDouble(clazz, key, def);
    }

    @Override
    public void putDouble(String key, Double value) {
        preferences.putDouble(key, value);
    }

    @Override
    public void putDouble(Class clazz, String key, Double value) {
        preferences.putDouble(clazz, key, value);
    }

    @Override
    public Integer getInt(String key, Integer def) {
        return preferences.getInt(key, def);
    }

    @Override
    public Integer getInt(Class clazz, String key, Integer def) {
        return preferences.getInt(clazz, key, def);
    }

    @Override
    public void putInt(String key, Integer value) {
        preferences.putInt(key, value);
    }

    @Override
    public void putInt(Class clazz, String key, Integer value) {
        preferences.putInt(clazz, key, value);
    }

    @Override
    public Long getLong(String key, Long def) {
        return preferences.getLong(key, def);
    }

    @Override
    public Long getLong(Class clazz, String key, Long def) {
        return preferences.getLong(clazz, key, def);
    }

    @Override
    public void putLong(String key, Long value) {
        preferences.putLong(key, value);
    }

    @Override
    public void putLong(Class clazz, String key, Long value) {
        preferences.putLong(clazz, key, value);
    }

    @Override
    public void init(boolean drop) {
        preferences.init(drop);
    }

    @Override
    public Preferences forApplication() {
        return preferences.forApplication();
    }

    @Override
    public Preferences forModule(Class clazz) {
        return preferences.forModule(clazz);
    }
    
}
