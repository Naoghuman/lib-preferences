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
package de.pro.lib.preferences;

import de.pro.lib.logger.api.LoggerFacade;
import de.pro.lib.preferences.api.PreferencesFacade;
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
public class PRoPreferencesTest {
    
    private static final String NORMAL_PATH
            = System.getProperty("user.dir") + File.separator // NOI18N
            + "Preferences.properties"; // NOI18N
    
    private static final String OWN_PATH
            = System.getProperty("user.dir") + File.separator // NOI18N
            + "own"; // NOI18N
    
    public PRoPreferencesTest() {
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
        PreferencesFacade.getDefault().init(true);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void initDefaultAndDropTrue() {
        final File file = new File(NORMAL_PATH);
        assertFalse(NORMAL_PATH + " mustn't exists", file.exists());
        
        PreferencesFacade.getDefault().put("x", "x");
        assertTrue(NORMAL_PATH + " must exists", file.exists());
    }
    
    @Test
    public void getStringInApplicationContext() {
        final String x = PreferencesFacade.getDefault().get("my.string.key", "x");
        assertEquals("x", x);
    }
    
    @Test
    public void putStringInApplicationContext() {
        PreferencesFacade.getDefault().put("my.string.key", "y");
        final String y = PreferencesFacade.getDefault().get("my.string.key", "x");
        assertEquals("y", y);
    }
    
    @Test
    public void getBooleanInApplicationContext() {
        final boolean x = PreferencesFacade.getDefault().getBoolean("my.boolean.key", true);
        assertEquals(true, x);
    }
    
    @Test
    public void putBooleanInApplicationContext() {
        PreferencesFacade.getDefault().putBoolean("my.boolean.key", false);
        final boolean y = PreferencesFacade.getDefault().getBoolean("my.boolean.key", true);
        assertEquals(false, y);
    }
    
    @Test
    public void getDoubleInApplicationContext() {
        final double x = PreferencesFacade.getDefault().getDouble("my.double.key", 1.23d);
        assertTrue(1.23d == x);
    }
    
    @Test
    public void putDoubleInApplicationContext() {
        PreferencesFacade.getDefault().putDouble("my.double.key", 0.0d);
        final double y = PreferencesFacade.getDefault().getDouble("my.double.key", 1.23d);
        assertTrue(0.0d == y);
    }
    
    @Test
    public void getIntInApplicationContext() {
        final int x = PreferencesFacade.getDefault().getInt("my.int.key", 1);
        assertTrue(1 == x);
    }
    
    @Test
    public void putIntInApplicationContext() {
        PreferencesFacade.getDefault().putInt("my.int.key", 0);
        final int y = PreferencesFacade.getDefault().getInt("my.int.key", 1);
        assertTrue(0 == y);
    }
    
    @Test
    public void getLongInApplicationContext() {
        final long x = PreferencesFacade.getDefault().getLong("my.long.key", 1L);
        assertTrue(1L == x);
    }
    
    @Test
    public void putLongInApplicationContext() {
        PreferencesFacade.getDefault().putLong("my.long.key", 0L);
        final long y = PreferencesFacade.getDefault().getLong("my.long.key", 1L);
        assertTrue(0L == y);
    }
    
    // -------------------------------------------------------------------------
    
    
    @Test
    public void getStringInModuleContext() {
        final String x = PreferencesFacade.getDefault().get(DummyModuleContext.class, "my.string.key", "x");
        assertEquals("x", x);
    }
    
    @Test
    public void putStringInModuleContext() {
        PreferencesFacade.getDefault().put(DummyModuleContext.class, "my.string.key", "y");
        final String y = PreferencesFacade.getDefault().get(DummyModuleContext.class, "my.string.key", "x");
        assertEquals("y", y);
    }
    
    @Test
    public void getBooleanInModuleContext() {
        final boolean x = PreferencesFacade.getDefault().getBoolean(DummyModuleContext.class, "my.boolean.key", true);
        assertEquals(true, x);
    }
    
    @Test
    public void putBooleanInModuleContext() {
        PreferencesFacade.getDefault().putBoolean(DummyModuleContext.class, "my.boolean.key", false);
        final boolean y = PreferencesFacade.getDefault().getBoolean(DummyModuleContext.class, "my.boolean.key", true);
        assertEquals(false, y);
    }
    
    @Test
    public void getDoubleInModuleContext() {
        final double x = PreferencesFacade.getDefault().getDouble(DummyModuleContext.class, "my.double.key", 1.23d);
        assertTrue(1.23d == x);
    }
    
    @Test
    public void putDoubleInModuleContext() {
        PreferencesFacade.getDefault().putDouble(DummyModuleContext.class, "my.double.key", 0.0d);
        final double y = PreferencesFacade.getDefault().getDouble(DummyModuleContext.class, "my.double.key", 1.23d);
        assertTrue(0.0d == y);
    }
    
    @Test
    public void getIntInModuleContext() {
        final int x = PreferencesFacade.getDefault().getInt(DummyModuleContext.class, "my.int.key", 1);
        assertTrue(1 == x);
    }
    
    @Test
    public void putIntInModuleContext() {
        PreferencesFacade.getDefault().putInt(DummyModuleContext.class, "my.int.key", 0);
        final int y = PreferencesFacade.getDefault().getInt(DummyModuleContext.class, "my.int.key", 1);
        assertTrue(0 == y);
    }
    
    @Test
    public void getLongInModuleContext() {
        final long x = PreferencesFacade.getDefault().getLong(DummyModuleContext.class, "my.long.key", 1L);
        assertTrue(1L == x);
    }
    
    @Test
    public void putLongInModuleContext() {
        PreferencesFacade.getDefault().putLong(DummyModuleContext.class, "my.long.key", 0L);
        final long y = PreferencesFacade.getDefault().getLong(DummyModuleContext.class, "my.long.key", 1L);
        assertTrue(0L == y);
    }
    
}
