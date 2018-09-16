/**
 * Copyright (C) 2018 Naoghuman
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

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public interface SimplePreferences2 {

    /**
     * 
     */
    public void application();

    /**
     * 
     */
//    public void drop();

    /**
     * 
     * @param def
     * @return 
     */
    public Boolean get(final Boolean def);

    /**
     * 
     * @param def
     * @return 
     */
    public Double get(final Double def);

    /**
     * 
     * @param def
     * @return 
     */
    public Integer get(final Integer def);

    /**
     * 
     * @param def
     * @return 
     */
    public Long get(final Long def);

    /**
     * 
     * @param def
     * @return 
     */
    public String get(final String def);

    /**
     * 
     * @param key 
     */
    public void key(final String key);

    /**
     * 
     * @param clazz 
     */
    public void module(final Class clazz);

    /**
     * 
     * @param value 
     */
    public void put(final Boolean value);

    /**
     * 
     * @param value 
     */
    public void put(final Double value);

    /**
     * 
     * @param value 
     */
    public void put(final Integer value);

    /**
     * 
     * @param value 
     */
    public void put(final Long value);

    /**
     * 
     * @param value 
     */
    public void put(final String value);
    
}
