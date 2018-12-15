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
package com.github.naoghuman.lib.preferences.internal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * UnitTests to test the factory {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences}.
 * 
 * TODO
 *  - all negative tests
 *  - all positive tests
 *
 * @since   0.6.0
 * @version 0.6.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences
 */
public class DefaultPreferencesTest {
    
    public DefaultPreferencesTest() {
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
        DefaultPreferences instance = new DefaultPreferences();
        instance.module(null);
    }
    
    // #########################################################################
    
    @Test(expected = NullPointerException.class)
    public void secondStepKeyThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.key(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void secondStepKeyThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.key("");
    }
    
    // #########################################################################
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetBooleanThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.get((Boolean) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetDoubleThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.get((Double) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetIntegerThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.get((Integer) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetLongThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.get((Long) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepGetStringThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.get((String) null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepGetStringThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.get("");
    }
    
    // #########################################################################
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepGetTwoTimesBooleanThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key100");
        
        instance.get(Boolean.TRUE);
        instance.get(Boolean.TRUE); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepGetTwoTimesDoubleThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key101");
        
        instance.get(1.2345d);
        instance.get(1.2345d); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepGetTwoTimesIntegerThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key102");
        
        instance.get(123456);
        instance.get(123456); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepGetTwoTimesLongThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key103");
        
        instance.get(123L);
        instance.get(123L); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepGetTwoTimesStringThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key104");
        
        instance.get("hello world");
        instance.get("hello world"); // throws
    }
    
    // #########################################################################
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepPutTwoTimesBooleanThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key110");
        
        instance.put(Boolean.TRUE);
        instance.put(Boolean.TRUE); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepPutTwoTimesDoubleThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key111");
        
        instance.put(1.2345d);
        instance.put(1.2345d); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepPutTwoTimesIntegerThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key112");
        
        instance.put(123456);
        instance.put(123456); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepPutTwoTimesLongThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key113");
        
        instance.put(123L);
        instance.put(123L); // throws
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepPutTwoTimesStringThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key114");
        
        instance.put("hello world");
        instance.put("hello world"); // throws
    }
    
    // #########################################################################
    
    @Test
    public void thirdStepGetBooleanReturnsDefaultValueTrue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key50");
        
        assertTrue(instance.get(Boolean.TRUE));
    }
    
    @Test
    public void thirdStepGetBooleanReturnsDefaultValueFalse() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key51");
        
        assertFalse(instance.get(Boolean.FALSE));
    }
    
    @Test
    public void thirdStepPutGetBooleanReturnsValueTrue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key52");
        instance.put(Boolean.TRUE);
        
        instance.key("dummy.key52");
        assertTrue(instance.get(Boolean.FALSE));
    }
    
    @Test
    public void thirdStepGetDoubleReturnsDefaultValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key53");
        
        assertEquals(1.2345d, instance.get(1.2345d), 0);
    }
    
    @Test
    public void thirdStepPutGetDoubleReturnsValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key54");
        instance.put(1.2345d);
        
        instance.key("dummy.key54");
        assertEquals(1.2345d, instance.get(5.4321d), 0);
    }
    
    @Test
    public void thirdStepGetIntegerReturnsDefaultValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key55");
        
        assertTrue(123456 == instance.get(123456));
    }
    
    @Test
    public void thirdStepPutGetIntegerReturnsValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key56");
        instance.put(123456);
        
        instance.key("dummy.key56");
        assertTrue(123456 == instance.get(654321));
    }
    
    @Test
    public void thirdStepGetLongReturnsDefaultValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key57");
        
        assertTrue(123L == instance.get(123L));
    }
    
    @Test
    public void thirdStepPutGetLongReturnsValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key58");
        instance.put(123L);
        
        instance.key("dummy.key58");
        assertTrue(123L == instance.get(321L));
    }
    
    @Test
    public void thirdStepGetStringReturnsDefaultValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key59");
        
        assertEquals("hello world", instance.get("hello world"));
    }
    
    @Test
    public void thirdStepPutGetStringReturnsValue() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key60");
        instance.put("hello world");
        
        instance.key("dummy.key60");
        assertEquals("hello world", instance.get("world hello"));
    }
    
    // #########################################################################
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutBooleanThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.put((Boolean) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutDoubleThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.put((Double) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutIntegerThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.put((Integer) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutLongThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.put((Long) null);
    }
    
    @Test(expected = NullPointerException.class)
    public void thirdStepPutStringThrowsNullPointerException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.put((String) null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void thirdStepPutStringThrowsIllegalArgumentException() {
        DefaultPreferences instance = new DefaultPreferences();
        instance.application();
        instance.key("dummy.key");
        instance.put("");
    }
    
    // #########################################################################
    
}
