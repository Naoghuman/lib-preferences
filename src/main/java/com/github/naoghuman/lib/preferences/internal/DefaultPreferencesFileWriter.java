/**
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
package com.github.naoghuman.lib.preferences.internal;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Writes the content from a {@link java.util.Properties} into a {@link java.io.File}.
 * <p>
 * In context from the library {@code Lib-Preferences} this is
 * <ul>
 * <li>an instance from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties} </li>
 * <li>and the file {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE}
 *     with the path from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR}.</li>
 * </ul>
 * 
 * @since   0.6.0
 * @version 0.6.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties
 * @see     java.io.File
 * @see     java.lang.NullPointerException
 * @see     java.util.Properties
 */
final class DefaultPreferencesFileWriter {

    /**
     * Writes the content from a {@link java.util.Properties} into a {@link java.io.File} with the constant 
     * {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_PROPERTIES_COMMANTARY} 
     * as header.
     * <p>
     * In context from the library {@code Lib-Preferences} this is
     * <ul>
     * <li>an instance from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties} </li>
     * <li>and the file {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE}
     *     with the path from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR}.</li>
     * </ul>
     * 
     * @param   properties the {@code Properties} which content should be written into the {@code File}.
     * @param   file       the {@code File} which should be updated.
     * @param   commentary the {@code commentray} which should be written as header in the .properties file.
     * @throws  NullPointerException if {@code (properties || file) == NULL}.
     * @since   0.6.0
     * @version 0.6.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE
     * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_PROPERTIES_COMMANTARY
     * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR
     * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties
     * @see     java.io.File
     * @see     java.lang.NullPointerException
     * @see     java.util.Properties
     */
    static void write(final DefaultPreferencesProperties properties, final File file) {
        DefaultPreferencesValidator.requireNonNull(properties);
        DefaultPreferencesValidator.requireNonNull(file);
        
        DefaultPreferencesFileWriter.write(properties, file, DefaultPreferences.DEFAULT_PREFERENCES_PROPERTIES_COMMANTARY);
    }
    
    /**
     * Writes the content from a {@link java.util.Properties} into a {@link java.io.File} with the 
     * {@code commentary} as header.
     * <p>
     * In context from the library {@code Lib-Preferences} this is
     * <ul>
     * <li>an instance from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties} </li>
     * <li>and the file {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE}
     *     with the path from {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR}.</li>
     * </ul>
     * 
     * @param   properties the {@code Properties} which content should be written into the {@code File}.
     * @param   file       the {@code File} which should be updated.
     * @param   commentary the {@code commentray} which should be written as header in the .properties file.
     * @throws  IllegalArgumentException if {@code (commentary) == EMPTY}.
     * @throws  NullPointerException     if {@code (properties || file) == NULL}.
     * @since   0.6.0
     * @version 0.6.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE
     * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#SYSTEM_PROPERTY__USER_DIR
     * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferencesProperties
     * @see     java.io.File
     * @see     java.lang.IllegalArgumentException
     * @see     java.lang.NullPointerException
     * @see     java.util.Properties
     */
    static void write(final DefaultPreferencesProperties properties, final File file, final String commentary) {
        DefaultPreferencesValidator.requireNonNull(properties);
        DefaultPreferencesValidator.requireNonNull(file);
        DefaultPreferencesValidator.requireNonNullAndNotEmpty(commentary);
        
        try(final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            properties.store(bos, commentary);
        } catch (IOException ioe) {
            LoggerFacade.getDefault().error(DefaultPreferencesFileWriter.class, 
                    "Can't write the content from the [properties] into the [file].", ioe); // NOI18N
        }
    }
    
}
