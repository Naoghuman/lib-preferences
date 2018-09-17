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
import java.io.File;
import java.util.Optional;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public final class DefaultSimplePreferences2 implements SimplePreferences2 {
    
    private static final String PREFERENCES_FILE          = "Preferences.properties"; // NOI18N
    private static final String SYSTEM_PROPERTY__USER_DIR = "user.dir"; // NOI18N
    
    private File file;
    private Optional<String>      optionalKey  = Optional.empty();
    private PreferencesProperties properties;
    private String prefix;
    
    public DefaultSimplePreferences2() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "DefaultSimplePreferences2.initialize()"); // NOI18N
        
        final StringBuilder sbFilePath = new StringBuilder();
        sbFilePath.append(System.getProperty(SYSTEM_PROPERTY__USER_DIR));
        sbFilePath.append(File.separator);
        sbFilePath.append(PREFERENCES_FILE);
        file = new File(sbFilePath.toString());
        
        properties = new PreferencesProperties();
        
        PreferencesFileReader.read(file, properties);
    }

    @Override
    public void application() {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.application()"); // NOI18N
        
        prefix = SimplePreferences2.class.getPackage().getName();
    }

//    @Override
//    public void drop() { // TODO reset only the content
//        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.drop()"); // NOI18N
//        
//        final File f = this.getFile();
//        if (f.exists()) {
//            LoggerFacade.getDefault().debug(this.getClass(), "  Delete file Preferences.properties"); // NOI18N
//
//            f.delete();
//
//            if (!properties.isEmpty()) {
//                properties.clear();
//            }
//
//            if (optionalKey.isPresent()) {
//                optionalKey = Optional.empty();
//            }
//        }
//    }

    @Override
    public Boolean get(final Boolean def) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.get(Boolean)"); // NOI18N
        
        Boolean value = def;
        if (
                optionalKey.isPresent()
                && properties.containsKey(optionalKey.get())
        ) {
            final String strValue = properties.getProperty(optionalKey.get());
            try {
                value = Boolean.valueOf(strValue);
                
                LoggerFacade.getDefault().own(this.getClass(), String.format("  Load " + optionalKey.get() + "=%b", value));// NOI18N
            } catch (NumberFormatException e) {
                LoggerFacade.getDefault().warn(this.getClass(), String.format(
                        "  Can't convert '%s' to Boolean. Use default value: %f", strValue, def)); // NOI18N
            }
        }
        
        return value;
    }

    @Override
    public Double get(final Double def) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.get(Double)"); // NOI18N
        
        Double value = def;
        if (
                optionalKey.isPresent()
                && properties.containsKey(optionalKey.get())
        ) {
            final String strValue = properties.getProperty(optionalKey.get());
            try {
                value = Double.valueOf(strValue);
            } catch (NumberFormatException e) {
                LoggerFacade.getDefault().warn(this.getClass(), String.format(
                        "  Can't convert '%s' to Double. Use default value: %f", strValue, def)); // NOI18N
            }
        }
        
        return value;
    }

    @Override
    public Integer get(final Integer def) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.get(Integer)"); // NOI18N
        
        Integer value = def;
        if (
                optionalKey.isPresent()
                && properties.containsKey(optionalKey.get())
        ) {
            final String strValue = properties.getProperty(optionalKey.get());
            try {
                value = Integer.valueOf(strValue);
            } catch (NumberFormatException e) {
                LoggerFacade.getDefault().warn(this.getClass(), String.format(
                        "  Can't convert '%s' to Integer. Use default value: %d", strValue, def)); // NOI18N
            }
        }
        
        return value;
    }

    @Override
    public Long get(final Long def) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.get(Long)"); // NOI18N
        
        Long value = def;
        if (
                optionalKey.isPresent()
                && properties.containsKey(optionalKey.get())
        ) {
            final String strValue = properties.getProperty(optionalKey.get());
            try {
                value = Long.valueOf(strValue);
            } catch (NumberFormatException e) {
                LoggerFacade.getDefault().warn(this.getClass(), String.format(
                        "  Can't convert '%s' to Long. Use default value: %d", strValue, def)); // NOI18N
            }
        }
        
        return value;
    }

    @Override
    public String get(final String def) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.get(String)"); // NOI18N
        
        String value = def;
        if (
                optionalKey.isPresent()
                && properties.containsKey(optionalKey.get())
        ) {
            value = properties.getProperty(optionalKey.get());
            
            LoggerFacade.getDefault().own(this.getClass(), String.format("  Load " + optionalKey.get() + "=%s", value));// NOI18N
        }
        else {
            LoggerFacade.getDefault().warn(this.getClass(), String.format("  Use default value: %s", def)); // NOI18N
        }
        
        return value;
    }

    @Override
    public void key(final String key) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.key(String)"); // NOI18N
        
        PreferencesValidator.requireNonNullAndNotEmpty(key);
        
        optionalKey = Optional.of(key);
    }

    @Override
    public void module(final Class clazz) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.module(Class)"); // NOI18N
        
        prefix = clazz.getPackage().getName();
    }

    @Override
    public void put(final Boolean value) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.put(Boolean)"); // NOI18N
        
        PreferencesValidator.requireNonNull(value);
        
        if (optionalKey.isPresent()) {
            properties.put(optionalKey.get(), value);
            PreferencesFileWriter.write(file, properties);
        
            LoggerFacade.getDefault().own(this.getClass(), String.format("  Save " + optionalKey.get() + "=%b", value)); // NOI18N
        }
    }

    @Override
    public void put(final Double value) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.put(Double)"); // NOI18N
        
        PreferencesValidator.requireNonNull(value);
        
        if (optionalKey.isPresent()) {
            properties.put(optionalKey.get(), value);
            PreferencesFileWriter.write(file, properties);
        
            LoggerFacade.getDefault().own(this.getClass(), String.format("  Save " + optionalKey.get() + "=%f", value)); // NOI18N
        }
    }

    @Override
    public void put(final Integer value) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.put(Integer)"); // NOI18N
        
        PreferencesValidator.requireNonNull(value);
        
        if (optionalKey.isPresent()) {
            properties.put(optionalKey.get(), value);
            PreferencesFileWriter.write(file, properties);
        
            LoggerFacade.getDefault().own(this.getClass(), String.format("  Save " + optionalKey.get() + "=%d", value)); // NOI18N
        }
    }

    @Override
    public void put(final Long value) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.put(Long)"); // NOI18N
        
        PreferencesValidator.requireNonNull(value);
        
        if (optionalKey.isPresent()) {
            properties.put(optionalKey.get(), value);
            PreferencesFileWriter.write(file, properties);
        
            LoggerFacade.getDefault().own(this.getClass(), String.format("  Save " + optionalKey.get() + "=%d", value)); // NOI18N
        }
    }

    @Override
    public void put(final String value) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultSimplePreferences2.put(String)"); // NOI18N
        
        PreferencesValidator.requireNonNull(value);
        
        if (optionalKey.isPresent()) {
            properties.put(optionalKey.get(), value);
            PreferencesFileWriter.write(file, properties);
        
            LoggerFacade.getDefault().own(this.getClass(), String.format("  Save " + optionalKey.get() + "=%s", value)); // NOI18N
        }
    }
    
}
