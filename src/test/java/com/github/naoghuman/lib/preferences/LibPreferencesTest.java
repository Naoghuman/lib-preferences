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
package com.github.naoghuman.lib.preferences;

import com.github.naoghuman.lib.logger.api.LoggerFacade;
import com.github.naoghuman.lib.preferences.api.PreferencesFacade;
import dummy.DummyModuleContext;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PRo
 */
public class LibPreferencesTest {
    
    private static final String NORMAL_PATH
            = System.getProperty("user.dir") + File.separator // NOI18N
            + "Preferences.properties"; // NOI18N
    
    private static final String OWN_PATH
            = System.getProperty("user.dir") + File.separator // NOI18N
            + "own"; // NOI18N
    
    public LibPreferencesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        LoggerFacade.getDefault().deactivate(Boolean.TRUE);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PreferencesFacade.INSTANCE.init(true);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void initDefaultAndDropTrue() {
        final File file = new File(NORMAL_PATH);
        assertFalse(NORMAL_PATH + " mustn't exists", file.exists());
        
        PreferencesFacade.INSTANCE.put("x", "x");
        assertTrue(NORMAL_PATH + " must exists", file.exists());
    }
    
    @Test
    public void getStringInApplicationContext() {
        final String x = PreferencesFacade.INSTANCE.get("my.string.key1", "x");
        assertEquals("x", x);
    }
    
    @Test
    public void putStringInApplicationContext() {
        PreferencesFacade.INSTANCE.put("my.string.key2", "y");
        final String y = PreferencesFacade.INSTANCE.get("my.string.key2", "x");
        assertEquals("y", y);
    }
    
    @Test
    public void getBooleanInApplicationContext() {
        final boolean x = PreferencesFacade.INSTANCE.getBoolean("my.boolean.key3", true);
        assertEquals(true, x);
    }
    
    @Test
    public void putBooleanInApplicationContext() {
        PreferencesFacade.INSTANCE.putBoolean("my.boolean.key4", false);
        final boolean y = PreferencesFacade.INSTANCE.getBoolean("my.boolean.key4", true);
        assertEquals(false, y);
    }
    
    @Test
    public void getDoubleInApplicationContext() {
        final double x = PreferencesFacade.INSTANCE.getDouble("my.double.key5", 1.23d);
        assertTrue(1.23d == x);
    }
    
    @Test
    public void putDoubleInApplicationContext() {
        PreferencesFacade.INSTANCE.putDouble("my.double.key6", 0.0d);
        final double y = PreferencesFacade.INSTANCE.getDouble("my.double.key6", 1.23d);
        assertTrue(0.0d == y);
    }
    
    @Test
    public void getIntInApplicationContext() {
        final int x = PreferencesFacade.INSTANCE.getInt("my.int.key7", 1);
        assertTrue(1 == x);
    }
    
    @Test
    public void putIntInApplicationContext() {
        PreferencesFacade.INSTANCE.putInt("my.int.key8", 0);
        final int y = PreferencesFacade.INSTANCE.getInt("my.int.key8", 1);
        assertTrue(0 == y);
    }
    
    @Test
    public void getLongInApplicationContext() {
        final long x = PreferencesFacade.INSTANCE.getLong("my.long.key9", 1L);
        assertTrue(1L == x);
    }
    
    @Test
    public void putLongInApplicationContext() {
        PreferencesFacade.INSTANCE.putLong("my.long.key10", 0L);
        final long y = PreferencesFacade.INSTANCE.getLong("my.long.key10", 1L);
        assertTrue(0L == y);
    }
    
    // -------------------------------------------------------------------------
    
    
    @Test
    public void getStringInModuleContext() {
        final String x = PreferencesFacade.INSTANCE.get(DummyModuleContext.class, "my.string.key11", "x");
        assertEquals("x", x);
    }
    
    @Test
    public void putStringInModuleContext() {
        PreferencesFacade.INSTANCE.put(DummyModuleContext.class, "my.string.key12", "y");
        final String y = PreferencesFacade.INSTANCE.get(DummyModuleContext.class, "my.string.key12", "x");
        assertEquals("y", y);
    }
    
    @Test
    public void getBooleanInModuleContext() {
        final boolean x = PreferencesFacade.INSTANCE.getBoolean(DummyModuleContext.class, "my.boolean.key13", true);
        assertEquals(true, x);
    }
    
    @Test
    public void putBooleanInModuleContext() {
        PreferencesFacade.INSTANCE.putBoolean(DummyModuleContext.class, "my.boolean.key14", false);
        final boolean y = PreferencesFacade.INSTANCE.getBoolean(DummyModuleContext.class, "my.boolean.key14", true);
        assertEquals(false, y);
    }
    
    @Test
    public void getDoubleInModuleContext() {
        final double x = PreferencesFacade.INSTANCE.getDouble(DummyModuleContext.class, "my.double.key15", 1.23d);
        assertTrue(1.23d == x);
    }
    
    @Test
    public void putDoubleInModuleContext() {
        PreferencesFacade.INSTANCE.putDouble(DummyModuleContext.class, "my.double.key16", 0.0d);
        final double y = PreferencesFacade.INSTANCE.getDouble(DummyModuleContext.class, "my.double.key16", 1.23d);
        assertTrue(0.0d == y);
    }
    
    @Test
    public void getIntInModuleContext() {
        final int x = PreferencesFacade.INSTANCE.getInt(DummyModuleContext.class, "my.int.key17", 1);
        assertTrue(1 == x);
    }
    
    @Test
    public void putIntInModuleContext() {
        PreferencesFacade.INSTANCE.putInt(DummyModuleContext.class, "my.int.key18", 0);
        final int y = PreferencesFacade.INSTANCE.getInt(DummyModuleContext.class, "my.int.key18", 1);
        assertTrue(0 == y);
    }
    
    @Test
    public void getLongInModuleContext() {
        final long x = PreferencesFacade.INSTANCE.getLong(DummyModuleContext.class, "my.long.key19", 1L);
        assertTrue(1L == x);
    }
    
    @Test
    public void putLongInModuleContext() {
        PreferencesFacade.INSTANCE.putLong(DummyModuleContext.class, "my.long.key20", 0L);
        final long y = PreferencesFacade.INSTANCE.getLong(DummyModuleContext.class, "my.long.key20", 1L);
        assertTrue(0L == y);
    }
    
}
