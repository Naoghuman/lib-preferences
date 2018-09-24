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
package com.github.naoghuman.lib.preferences.core;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.internal.DefaultSimplePreferences2;
import com.github.naoghuman.lib.preferences.internal.PreferencesValidator;
import com.github.naoghuman.lib.preferences.internal.SimplePreferences2;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public final class PrefercencesFactory {
    
    /**
     * 
     * @author Naoghuman
     * @since  0.6.0
     * @return 
     */
    public static FirstStep create() {
        return new PreferencesFactoryImpl();
    }
    
    /**
     * @author Naoghuman
     * @since  0.6.0
     */
    public interface FirstStep {
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @return 
         */
        public SecondStep application();
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  clazz
         * @return 
         */
        public SecondStep module(final Class clazz);
        
    }
    
    /**
     * @author Naoghuman
     * @since  0.6.0
     */
    public interface SecondStep {
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  key
         * @return 
         */
        public ThirdStep key(final String key);
        
    }
    
    /**
     * @author Naoghuman
     * @since  0.6.0
     */
    public interface ThirdStep {
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  def
         * @return 
         */
        public Boolean get(final Boolean def);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  def
         * @return 
         */
        public Double get(final Double def);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  def
         * @return 
         */
        public Integer get(final Integer def);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  def
         * @return 
         */
        public Long get(final Long def);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  def
         * @return 
         */
        public String get(final String def);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  value
         */
        public void put(final Boolean value);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  value
         */
        public void put(final Double value);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  value
         */
        public void put(final Integer value);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  value
         */
        public void put(final Long value);
        
        /**
         * @author Naoghuman
         * @since  0.6.0
         * @param  value
         */
        public void put(final String value);
        
    }
    
    private static final class PreferencesFactoryImpl implements 
            FirstStep, SecondStep, ThirdStep
    {
        private SimplePreferences2 preferences;
        
        PreferencesFactoryImpl() {
            this.initialize();
        }
        
        
        private void initialize() {
            LoggerFacade.getDefault().info(this.getClass(), "PreferencesFactory.initialize()"); // NOI18N
        
            preferences = new DefaultSimplePreferences2();
        }

        @Override
        public SecondStep application() {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.application()"); // NOI18N
        
            preferences.application();
            return this;
        }

        @Override
        public SecondStep module(final Class clazz) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.module(Class)"); // NOI18N
        
            PreferencesValidator.requireNonNull(clazz);
            preferences.module(clazz);
            
            return this;
        }

        @Override
        public ThirdStep key(final String key) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.key(String)"); // NOI18N
        
            PreferencesValidator.requireNonNullAndNotEmpty(key);
            preferences.key(key);
            
            return this;
        }

        @Override
        public Boolean get(final Boolean def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.get(Boolean)"); // NOI18N
        
            PreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public Double get(final Double def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.get(Double)"); // NOI18N
        
            PreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public Integer get(final Integer def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.get(Integer)"); // NOI18N
        
            PreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public Long get(final Long def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.get(Long)"); // NOI18N
        
            PreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public String get(final String def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.get(String)"); // NOI18N
        
            PreferencesValidator.requireNonNullAndNotEmpty(def);
            return preferences.get(def);
        }

        @Override
        public void put(final Boolean value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.put(Boolean)"); // NOI18N
        
            PreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final Double value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.put(Double)"); // NOI18N
        
            PreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final Integer value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.put(Integer)"); // NOI18N
        
            PreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final Long value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.put(Long)"); // NOI18N
        
            PreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final String value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactory.put(String)"); // NOI18N
        
            PreferencesValidator.requireNonNullAndNotEmpty(value);
            preferences.put(value);
        }
        
    }
    
}
