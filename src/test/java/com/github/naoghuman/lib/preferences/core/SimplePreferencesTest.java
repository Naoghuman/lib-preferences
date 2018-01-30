/*
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

import dummy.module.context.DummyModuleContext;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 */
public class SimplePreferencesTest {
    
    private static final String NORMAL_PATH
            = System.getProperty("user.dir") + File.separator // NOI18N
            + "Preferences.properties"; // NOI18N
    
    private static final String OWN_PATH
            = System.getProperty("user.dir") + File.separator // NOI18N
            + "own"; // NOI18N
    
    public SimplePreferencesTest() {
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
    
    /**
     * The file {@code Preferences.properties} will only generated if a last one 
     * {@code key-value} pair is written to the file.
     * <p>
     * This test will write following statement in the file:<br>
     * {@code com.github.naoghuman.lib.preferences.internal.x=x}
     * 
     * @author Naoghuman
     */
    @Test
    public void initDefaultAndDropTrue() {
        final File file = new File(NORMAL_PATH);
        assertFalse(NORMAL_PATH + " mustn't exists", file.exists());
        
        PreferencesFacade.getDefault().put("x", "x");
        assertTrue(NORMAL_PATH + " must exists", file.exists());
    }
    
    /**
     * Searching in {@code ApplicationContext} means in this case that the engine 
     * search for a {@code key=my.string.key1} with a prefix 
     * {@code com.github.naoghuman.lib.preferences.internal}. So the complete {@code key}
     * for the search is {@code com.github.naoghuman.lib.preferences.internal.my.string.key1}.
     * <p>
     * If the {@code key} is not found in the file {@code Preferences.properties}
     * then the {@code default} value will returned, in this case {@code x}.
     * 
     * @author Naoghuman
     */
    @Test
    public void getDefaultStringInApplicationContext() {
        final String defaultValue = PreferencesFacade.getDefault().get("my.string.key1", "x");
        assertEquals("x", defaultValue);
    }
    
    /**
     * Putting a {@code value} in the file {@code Preferences.properties} in 
     * {@code ApplicationContext} will write in this case following statement in 
     * the file:<br>
     * {@code com.github.naoghuman.lib.preferences.internal.my.string.key2=y}
     * <p>
     * Searching / writing in {@code ApplicationContext} means in this case that 
     * the engine search / write a {@code key=my.string.key2} with a prefix 
     * {@code com.github.naoghuman.lib.preferences.internal}. So the complete {@code key}
     * for the search / to write is {@code com.github.naoghuman.lib.preferences.internal.my.string.key2}.
     * <p>
     * Because the search engine find the {@code key} in the file not the {@code default} 
     * value {@code x} will be returned instead the stored value {@code y} will used.
     * 
     * @author Naoghuman
     */
    @Test
    public void putStringInApplicationContext() {
        PreferencesFacade.getDefault().put("my.string.key2", "y");
        
        final String storedValue = PreferencesFacade.getDefault().get("my.string.key2", "x");
        assertEquals("y", storedValue);
    }
    
    @Test
    public void getDefaultBooleanInApplicationContext() {
        final boolean defaultValue = PreferencesFacade.getDefault().getBoolean("my.boolean.key3", true);
        assertEquals(true, defaultValue);
    }
    
    @Test
    public void putBooleanInApplicationContext() {
        PreferencesFacade.getDefault().putBoolean("my.boolean.key4", false);
        
        final boolean storedValue = PreferencesFacade.getDefault().getBoolean("my.boolean.key4", true);
        assertEquals(false, storedValue);
    }
    
    @Test
    public void getDefaultDoubleInApplicationContext() {
        final double defaultValue = PreferencesFacade.getDefault().getDouble("my.double.key5", 1.23d);
        assertTrue(1.23d == defaultValue);
    }
    
    @Test
    public void putDoubleInApplicationContext() {
        PreferencesFacade.getDefault().putDouble("my.double.key6", 0.0d);
        
        final double storedValue = PreferencesFacade.getDefault().getDouble("my.double.key6", 1.23d);
        assertTrue(0.0d == storedValue);
    }
    
    @Test
    public void getDefaultIntInApplicationContext() {
        final int defaultValue = PreferencesFacade.getDefault().getInt("my.int.key7", 1);
        assertTrue(1 == defaultValue);
    }
    
    @Test
    public void putIntInApplicationContext() {
        PreferencesFacade.getDefault().putInt("my.int.key8", 0);
        
        final int storedValue = PreferencesFacade.getDefault().getInt("my.int.key8", 1);
        assertTrue(0 == storedValue);
    }
    
    @Test
    public void getDefaultLongInApplicationContext() {
        final long defaultValue = PreferencesFacade.getDefault().getLong("my.long.key9", 1L);
        assertTrue(1L == defaultValue);
    }
    
    @Test
    public void putLongInApplicationContext() {
        PreferencesFacade.getDefault().putLong("my.long.key10", 0L);
        
        final long storedValue = PreferencesFacade.getDefault().getLong("my.long.key10", 1L);
        assertTrue(0L == storedValue);
    }
    
    // -------------------------------------------------------------------------
    
    @Test
    public void getDefaultStringInModuleContext() {
        final String defaultValue = PreferencesFacade.getDefault().get(DummyModuleContext.class, "my.string.key11", "x");
        assertEquals("x", defaultValue);
    }
    
    @Test
    public void putStringInModuleContext() {
        PreferencesFacade.getDefault().put(DummyModuleContext.class, "my.string.key12", "y");
        
        final String storedValue = PreferencesFacade.getDefault().get(DummyModuleContext.class, "my.string.key12", "x");
        assertEquals("y", storedValue);
    }
    
    /**
     * Searching in {@code ModuleContext} means that the engine search in the package 
     * context from the given {@code class}.
     * <p>
     * In the context from the class {@code dummy.module.context.DummyModuleContext}
     * the engine search for a {@code key=my.boolean.key13} with a prefix 
     * {@code dummy.module.context}. So the complete {@code key} for the search is 
     * {@code dummy.module.context.my.boolean.key13}.
     * <p>
     * Because the {@code key} is not found in the file {@code Preferences.properties}
     * so the {@code default} value will returned, in this case {@code true}.
     * 
     * @author Naoghuman
     */
    @Test
    public void getDefaultBooleanInModuleContext() {
        final boolean defaultValue = PreferencesFacade.getDefault().getBoolean(DummyModuleContext.class, "my.boolean.key13", true);
        assertEquals(true, defaultValue);
    }
    
    /**
     * Putting a {@code value}in the file {@code Preferences.properties} in 
     * {@code ModuleContext} will write in this case following statement in the file:<br>
     * {@code dummy.module.context.my.boolean.key14=true}
     * <p>
     * Searching / writing in {@code ModuleContext} means that the engine search / write 
     * in the package context from the given {@code class} (in this case 
     * {@code dummy.module.context.DummyModuleContext}).So the complete {@code key} for 
     * the search / to write is {@code dummy.module.context.my.boolean.key14}.
     * <p>
     * Because the search engine find the {@code key} in the file not the {@code default} 
     * {@code true} will be returned instead the stored value {@code false} will used.
     * 
     * @author Naoghuman
     */
    @Test
    public void putBooleanInModuleContext() {
        PreferencesFacade.getDefault().putBoolean(DummyModuleContext.class, "my.boolean.key14", false);
        
        final boolean storedValue = PreferencesFacade.getDefault().getBoolean(DummyModuleContext.class, "my.boolean.key14", true);
        assertEquals(false, storedValue);
    }
    
    @Test
    public void getDefaultDoubleInModuleContext() {
        final double defaultValue = PreferencesFacade.getDefault().getDouble(DummyModuleContext.class, "my.double.key15", 1.23d);
        assertTrue(1.23d == defaultValue);
    }
    
    @Test
    public void putDoubleInModuleContext() {
        PreferencesFacade.getDefault().putDouble(DummyModuleContext.class, "my.double.key16", 0.0d);
        
        final double storedValue = PreferencesFacade.getDefault().getDouble(DummyModuleContext.class, "my.double.key16", 1.23d);
        assertTrue(0.0d == storedValue);
    }
    
    @Test
    public void getDefaultIntInModuleContext() {
        final int defaultValue = PreferencesFacade.getDefault().getInt(DummyModuleContext.class, "my.int.key17", 1);
        assertTrue(1 == defaultValue);
    }
    
    @Test
    public void putIntInModuleContext() {
        PreferencesFacade.getDefault().putInt(DummyModuleContext.class, "my.int.key18", 0);
        
        final int storedValue = PreferencesFacade.getDefault().getInt(DummyModuleContext.class, "my.int.key18", 1);
        assertTrue(0 == storedValue);
    }
    
    @Test
    public void getDefaultLongInModuleContext() {
        final long defaultValue = PreferencesFacade.getDefault().getLong(DummyModuleContext.class, "my.long.key19", 1L);
        assertTrue(1L == defaultValue);
    }
    
    @Test
    public void putLongInModuleContext() {
        PreferencesFacade.getDefault().putLong(DummyModuleContext.class, "my.long.key20", 0L);
        
        final long storedValue = PreferencesFacade.getDefault().getLong(DummyModuleContext.class, "my.long.key20", 1L);
        assertTrue(0L == storedValue);
    }
    
}
