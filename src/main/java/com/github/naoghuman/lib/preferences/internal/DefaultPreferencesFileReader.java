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

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Reads the content from a {@link java.io.File} into a {@link java.util.Properties}.
 * <p>
 * In context from the library {@code Lib-Preferences} this is
 * <ul>
 * <li>the file {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#PREFERENCES_FILE}
 *     with the path from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR}</li>
 * <li>and an instance from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties}.</li>
 * </ul>
 *
 * @since  0.6.0
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.preferences.internal.DefaultPreferences#PREFERENCES_FILE
 * @see    com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR
 * @see    com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties
 * @see    java.io.File
 * @see    java.util.Properties
 */
final class DefaultPreferencesFileReader {

    /**
     * Reads the content from a {@link java.io.File} into a {@link java.util.Properties}.
     * <p>
     * In context from the library {@code Lib-Preferences} this is
     * <ul>
     * <li>the file {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#PREFERENCES_FILE}
     *     with the path from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR}</li>
     * <li>and an instance from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties}.</li>
     * </ul>
     * 
     * @param  file       the {@code File} which content should be read.
     * @param  properties the {@code Properties} which should be updated with the 
     *                    content from the {@code File}.
     * @throws NullPointerException if {@code (file || properties) == NULL}.
     * @since  0.6.0
     * @author Naoghuman
     * @see    com.github.naoghuman.lib.preferences.internal.DefaultPreferences#PREFERENCES_FILE
     * @see    com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR
     * @see    com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties
     * @see    java.io.File
     * @see    java.lang.NullPointerException
     * @see    java.util.Properties
     */
    static void read(final File file, final Properties properties) {
        DefaultPreferencesValidator.requireNonNull(file);
        DefaultPreferencesValidator.requireNonNull(properties);
        
        try(final BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            properties.load(bis);
        } catch (IOException ioe) {
            LoggerFacade.getDefault().error(DefaultPreferencesFileWriter.class, 
                    "Can't read the content the file into the properties.", ioe); // NOI18N
        }
    }
    
}
