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
package com.github.naoghuman.lib.preferences.api;

import com.github.naoghuman.lib.preferences.LibPreferences;
import java.util.Optional;
import java.util.prefs.Preferences;

/**
 * The facade {@link com.github.naoghuman.lib.preferences.api.PreferencesFacade} provides 
 * access to the Interface {@link com.github.naoghuman.lib.preferences.api.ILibPreferences}.
 *
 * @author PRo
 * @see com.github.naoghuman.lib.preferences.api.ILibPreferences
 */
@Deprecated
public final class PreferencesFacade implements ILibPreferences {
    
    private static final Optional<PreferencesFacade> instance = Optional.of(new PreferencesFacade());

    /**
     * Returns a singleton instance from the class <code>PreferencesFacade</code>.
     * 
     * @return a singleton instance from the class <code>PreferencesFacade</code>.
     */
    @Deprecated
    public static final PreferencesFacade getDefault() {
        return instance.get();
    }
    
    private ILibPreferences preferences = null;
    
    private PreferencesFacade() {
        this.initialize();
    }
    
    private void initialize() {
        preferences = new LibPreferences();
    }

    @Override
    @Deprecated
    public Boolean getBoolean(String key, Boolean def) {
        return preferences.getBoolean(key, def);
    }

    @Override
    @Deprecated
    public Boolean getBoolean(Class clazz, String key, Boolean def) {
        return preferences.getBoolean(clazz, key, def);
    }

    @Override
    @Deprecated
    public void putBoolean(String key, Boolean value) {
        preferences.putBoolean(key, value);
    }

    @Override
    @Deprecated
    public void putBoolean(Class clazz, String key, Boolean value) {
        preferences.putBoolean(clazz, key, value);
    }

    @Override
    @Deprecated
    public String get(String key, String def) {
        return preferences.get(key, def);
    }

    @Override
    @Deprecated
    public String get(Class clazz, String key, String def) {
        return preferences.get(clazz, key, def);
    }

    @Override
    @Deprecated
    public void put(String key, String value) {
        preferences.put(key, value);
    }

    @Override
    @Deprecated
    public void put(Class clazz, String key, String value) {
        preferences.put(clazz, key, value);
    }

    @Override
    @Deprecated
    public Double getDouble(String key, Double def) {
        return preferences.getDouble(key, def);
    }

    @Override
    @Deprecated
    public Double getDouble(Class clazz, String key, Double def) {
        return preferences.getDouble(clazz, key, def);
    }

    @Override
    @Deprecated
    public void putDouble(String key, Double value) {
        preferences.putDouble(key, value);
    }

    @Override
    @Deprecated
    public void putDouble(Class clazz, String key, Double value) {
        preferences.putDouble(clazz, key, value);
    }

    @Override
    @Deprecated
    public Integer getInt(String key, Integer def) {
        return preferences.getInt(key, def);
    }

    @Override
    @Deprecated
    public Integer getInt(Class clazz, String key, Integer def) {
        return preferences.getInt(clazz, key, def);
    }

    @Override
    @Deprecated
    public void putInt(String key, Integer value) {
        preferences.putInt(key, value);
    }

    @Override
    @Deprecated
    public void putInt(Class clazz, String key, Integer value) {
        preferences.putInt(clazz, key, value);
    }

    @Override
    @Deprecated
    public Long getLong(String key, Long def) {
        return preferences.getLong(key, def);
    }

    @Override
    @Deprecated
    public Long getLong(Class clazz, String key, Long def) {
        return preferences.getLong(clazz, key, def);
    }

    @Override
    @Deprecated
    public void putLong(String key, Long value) {
        preferences.putLong(key, value);
    }

    @Override
    @Deprecated
    public void putLong(Class clazz, String key, Long value) {
        preferences.putLong(clazz, key, value);
    }

    @Override
    @Deprecated
    public void init(boolean drop) {
        preferences.init(drop);
    }

    @Override
    @Deprecated
    public Preferences forApplication() {
        return preferences.forApplication();
    }

    @Override
    @Deprecated
    public Preferences forModule(Class clazz) {
        return preferences.forModule(clazz);
    }
 
}
