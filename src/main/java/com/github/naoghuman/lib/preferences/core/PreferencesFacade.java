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

import com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences;
import java.util.Optional;
import java.util.prefs.Preferences;

/**
 * The facade {@link com.github.naoghuman.lib.preferences.core.PreferencesFacade} 
 * provides access to the default implementation from the {@code Interface} 
 * {@link com.github.naoghuman.lib.preferences.core.SimplePreferences}.
 * <p>
 * The default implementation from the {@code Interface} {@code SimplePreferences} is 
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.preferences.core.SimplePreferences
 * @see com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences
 */
public final class PreferencesFacade implements SimplePreferences {
    
    private static final Optional<PreferencesFacade> instance = Optional.of(new PreferencesFacade());

    /**
     * Returns a singleton instance from the class {@code PreferencesFacade}.
     * 
     * @return a singleton instance from the class {@code PreferencesFacade}.
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
    public Boolean getBoolean(final String key, final Boolean def) {
        return preferences.getBoolean(key, def);
    }

    @Override
    public Boolean getBoolean(final Class clazz, final String key, final Boolean def) {
        return preferences.getBoolean(clazz, key, def);
    }

    @Override
    public void putBoolean(final String key, final Boolean value) {
        preferences.putBoolean(key, value);
    }

    @Override
    public void putBoolean(final Class clazz, final String key, final Boolean value) {
        preferences.putBoolean(clazz, key, value);
    }

    @Override
    public String get(final String key, final String def) {
        return preferences.get(key, def);
    }

    @Override
    public String get(final Class clazz, final String key, final String def) {
        return preferences.get(clazz, key, def);
    }

    @Override
    public void put(final String key, final String value) {
        preferences.put(key, value);
    }

    @Override
    public void put(final Class clazz, final String key, final String value) {
        preferences.put(clazz, key, value);
    }

    @Override
    public Double getDouble(final String key, final Double def) {
        return preferences.getDouble(key, def);
    }

    @Override
    public Double getDouble(final Class clazz, final String key, final Double def) {
        return preferences.getDouble(clazz, key, def);
    }

    @Override
    public void putDouble(final String key, final Double value) {
        preferences.putDouble(key, value);
    }

    @Override
    public void putDouble(final Class clazz, final String key, final Double value) {
        preferences.putDouble(clazz, key, value);
    }

    @Override
    public Integer getInt(final String key, final Integer def) {
        return preferences.getInt(key, def);
    }

    @Override
    public Integer getInt(final Class clazz, final String key, final Integer def) {
        return preferences.getInt(clazz, key, def);
    }

    @Override
    public void putInt(final String key, final Integer value) {
        preferences.putInt(key, value);
    }

    @Override
    public void putInt(final Class clazz, final String key, final Integer value) {
        preferences.putInt(clazz, key, value);
    }

    @Override
    public Long getLong(final String key, final Long def) {
        return preferences.getLong(key, def);
    }

    @Override
    public Long getLong(final Class clazz, final String key, final Long def) {
        return preferences.getLong(clazz, key, def);
    }

    @Override
    public void putLong(final String key, final Long value) {
        preferences.putLong(key, value);
    }

    @Override
    public void putLong(final Class clazz, final String key, final Long value) {
        preferences.putLong(clazz, key, value);
    }

    @Override
    public void init(final boolean drop) {
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
