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
 * {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesFileReader}.
 * 
 * @since   0.6.0
 * @version 0.6.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferencesFileReader
 */
public class DefaultPreferencesFileReaderTest {
    
    public DefaultPreferencesFileReaderTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void readThrowsNullPointerExceptionCaseFile() {
        File       file       = null;
        Properties properties = new Properties();
        
        DefaultPreferencesFileReader.read(file, properties);
    }

    @Test(expected = NullPointerException.class)
    public void readThrowsNullPointerExceptionCaseProperties() {
        File       file       = new File("dummy-file.txt");
        Properties properties = null;
        
        DefaultPreferencesFileReader.read(file, properties);
    }
    
    @Test
    public void readFilePreferencesWithKeyValue() {
        String pathPlusFile = System.getProperty("user.dir")
                + File.separator
                + "Preferences_"
                + System.nanoTime()
                + ".properties";
        
        File file = new File(pathPlusFile);
        assertFalse(file.exists());
        
        DefaultPreferencesProperties p = new DefaultPreferencesProperties();
        p.setProperty("hallo", "ja?");
        DefaultPreferencesFileWriter.write(p, file);
        
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
