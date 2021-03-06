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

import java.io.File;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * UnitTests to test the default implementation 
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesFileWriter}.
 *
 * @since   0.6.0
 * @version 0.6.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferencesFileWriter
 */
public class DefaultPreferencesFileWriterTest {
    
    public DefaultPreferencesFileWriterTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void writeThrowsNullPointerExceptionCaseDefaultPreferencesProperties() {
        DefaultPreferencesProperties defaultPreferencesProperties = null;
        File file = new File("dummy-file.txt");
        
        DefaultPreferencesFileWriter.write(defaultPreferencesProperties, file);
    }
    
    @Test(expected = NullPointerException.class)
    public void writeThrowsNullPointerExceptionCaseFile() {
        DefaultPreferencesProperties defaultPreferencesProperties = new DefaultPreferencesProperties();
        File file = null;
        
        DefaultPreferencesFileWriter.write(defaultPreferencesProperties, file);
    }
    
    @Test
    public void writeFilePreferences() {
        String pathPlusFile = System.getProperty("user.dir")
                + File.separator
                + "Preferences_"
                + System.nanoTime()
                + ".properties";
        
        File file = new File(pathPlusFile);
        assertFalse(file.exists());
        
        DefaultPreferencesProperties defaultPreferencesProperties = new DefaultPreferencesProperties();
        DefaultPreferencesFileWriter.write(defaultPreferencesProperties, file);
        
        File file2 = new File(pathPlusFile);
        assertTrue(file2.exists());
        
        if (file.exists()) {
            assertTrue(file.delete());
        }
    }
    
    @Test
    public void writeFilePreferencesWithKeyValue() {
        String pathPlusFile = System.getProperty("user.dir")
                + File.separator
                + "Preferences_"
                + System.nanoTime()
                + ".properties";
        
        File file = new File(pathPlusFile);
        assertFalse(file.exists());
        
        DefaultPreferencesProperties defaultPreferencesProperties = new DefaultPreferencesProperties();
        defaultPreferencesProperties.setProperty("hallo", "ja?");
        DefaultPreferencesFileWriter.write(defaultPreferencesProperties, file);
        
        File file2 = new File(pathPlusFile);
        assertTrue(file2.exists());
        
        Properties properties = new Properties();
        DefaultPreferencesFileReader.read(file2, properties);
        
        assertTrue(properties.containsKey("hallo"));
        
        if (file.exists()) {
            assertTrue(file.delete());
        }
    }
    
}
