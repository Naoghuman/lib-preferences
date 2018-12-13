/*
 * Copyright (C) 2014 - 2018 Naoghuman's dream
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

import dummy.module.scope.DummyModuleScope;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * UnitTests to test the factory {@link com.github.naoghuman.lib.preferences.core.PreferencesFactory}.
 * 
 * @since   0.6.0
 * @version 0.6.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.preferences.core.PreferencesFactory
 */
public class PreferencesFactoryTest {
    
    public PreferencesFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // #########################################################################
    
    @Test(expected = NullPointerException.class)
    public void firstStepModuleThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(null)
                .key("dummy.key")
                .get("dummy.default.value");
    }
    
    // #########################################################################
    
    @Test(expected = NullPointerException.class)
    public void secondStepKeyThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key(null)
                .get("dummy.default.value");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void secondStepKeyThrowsIllegalArgumentException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("")
                .get("dummy.default.value");
    }
    
    // #########################################################################
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetBooleanThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .get((Boolean) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetDoubleThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .get((Double) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetIntegerThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .get((Integer) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetLongThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .get((Long) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetStringThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .get((String) null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepGetStringThrowsIllegalArgumentException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .get("");
    }
    
    // #########################################################################
    
    @Test
    public void thirdStepGetBooleanReturnsDefaultValueTrue() {
        assertTrue(PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key1")
                .get(Boolean.TRUE));
    }
    
    @Test
    public void thirdStepGetBooleanReturnsDefaultValueFalse() {
        assertFalse(PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key2")
                .get(Boolean.FALSE));
    }
    
    @Test
    public void thirdStepPutGetBooleanReturnsValueTrue() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key3")
                .put(Boolean.TRUE);
        
        assertTrue(PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key3")
                .get(Boolean.TRUE));
    }
    
    @Test
    public void thirdStepGetDoubleReturnsDefaultValue() {
        double result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key5")
                .get(1.2345d);
        assertEquals(1.2345d, result, 0);
    }
    
    @Test
    public void thirdStepPutGetDoubleReturnsValue() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key6")
                .put(1.2345d);
        
        double result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key6")
                .get(5.4321d);
        assertEquals(1.2345d, result, 0);
    }
    
    @Test
    public void thirdStepGetIntegerReturnsDefaultValue() {
        int result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key7")
                .get(123456);
        assertTrue(123456 == result);
    }
    
    @Test
    public void thirdStepPutGetIntegerReturnsValue() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key8")
                .put(123456);
        
        int result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key8")
                .get(654321);
        assertTrue(123456 == result);
    }
    
    @Test
    public void thirdStepGetLongReturnsDefaultValue() {
        long result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key9")
                .get(123L);
        assertTrue(123L == result);
    }
    
    @Test
    public void thirdStepPutGetLongReturnsValue() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key10")
                .put(123L);
        
        long result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key10")
                .get(321L);
        assertTrue(123L == result);
    }
    
    @Test
    public void thirdStepGetStringReturnsDefaultValue() {
        String result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key11")
                .get("hello world");
        assertEquals("hello world", result);
    }
    
    @Test
    public void thirdStepPutGetStringReturnsValue() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key12")
                .put("hello world");
        
        String result = PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key12")
                .get("world hello");
        assertEquals("hello world", result);
    }
    
    // #########################################################################
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutBooleanThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .put((Boolean) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutDoubleThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .put((Double) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutIntegerThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .put((Integer) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutLongThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .put((Long) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutStringThrowsNullPointerException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .put((String) null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepPutStringThrowsIllegalArgumentException() {
        PreferencesFactory.create()
                .module(DummyModuleScope.class)
                .key("dummy.key")
                .put("");
    }
    
    // #########################################################################
    
}
