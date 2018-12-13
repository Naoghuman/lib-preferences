/**
 * Copyright (C) 2018 - 2018 Naoghuman's dream
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * UnitTests to test the default implementation 
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesValidator}.
 *
 * @since   0.6.0
 * @version 0.6.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferencesValidator
 */
public class DefaultPreferencesValidatorTest {
    
    public DefaultPreferencesValidatorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void requireNonNull() {
        String hello = "hello";
        DefaultPreferencesValidator.requireNonNull(hello);
    }
    
    @Test(expected = NullPointerException.class)
    public void requireNonNullThrowsNullPointerException() {
        String hello = null;
        DefaultPreferencesValidator.requireNonNull(hello);
    }
    
    @Test
    public void requireNonNullAndNotEmptyString() {
        String hello = "hello";
        DefaultPreferencesValidator.requireNonNullAndNotEmpty(hello);
    }
    
    @Test(expected = NullPointerException.class)
    public void requireNonNullAndNotEmptyStringThrowsNullPointerException() {
        String hello = null;
        DefaultPreferencesValidator.requireNonNullAndNotEmpty(hello);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void requireNonNullAndNotEmptyStringThrowsIllegalArgumentException() {
        String hello = "";
        DefaultPreferencesValidator.requireNonNullAndNotEmpty(hello);
    }
    
}
