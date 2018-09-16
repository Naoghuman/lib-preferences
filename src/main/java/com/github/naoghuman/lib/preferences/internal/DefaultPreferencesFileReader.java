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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
final class DefaultPreferencesFileReader implements PreferencesReader {

    @Override
    public void read(final File file, final Properties properties) {
        
        try(final BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            properties.load(bis);
        } catch (IOException e) {
            
        }
    }
    
}
