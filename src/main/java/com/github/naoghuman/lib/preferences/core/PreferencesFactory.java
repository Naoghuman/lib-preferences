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
package com.github.naoghuman.lib.preferences.core;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.internal.DefaultPreferences;
import com.github.naoghuman.lib.preferences.internal.DefaultPreferencesValidator;

/**
 * With this factory the developer have the possibilities to simplify the access 
 * to the file {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE}.
 * <p>
 * After the definition from the scope the developer can specify in the second step the 
 * {@code key} which then in the third step will be used to store a new {@code value} 
 * or received an existing value. In the last case the developer can define an additional 
 * {@code default} value which will returned if the key doesn't exist.
 * <ul>
 * <li>Application scope means that the {@code key} must be <b>unique</b> in the <i>hole</i> application.</li>
 * <li>Module scope means that the {@code key} must be <b>unique</b> in a <i>package</i> scope.</li>
 * </ul>
 * <p>
 * Specification: <i>Usage from PreferencesFactory</i>
 * <pre>
 *   1) Starts the factory process.
 *   2) Activate the 'application' scope.
 *   3) Activate the 'package' scope.
 *   4) Defines the 'key'.
 *   5) Returns the 'value' from type 'T'.
 *   6) Stores the value from type 'T'.
 *   PreferencesFactory.create() // 1
 *          .application()       // 2
 *          .module(Class)       // 3
 *          .key(final String)   // 4
 *          .get(T);             // 5
 *          .put(T);             // 6
 * </pre>
 * 
 * @since   0.6.0
 * @version 0.6.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#DEFAULT_PREFERENCES_FILE
 * @see     java.util.Properties
 */
public final class PreferencesFactory {
    
    /**
     * Starts the factory. Leads to the first decision from the developer, taken 
     * in the interface {@code FirstStep}.
     * 
     * @return  the first step in this factory: {@code FirstStep}
     * @since   0.6.0
     * @version 0.6.0
     * @author  Naoghuman
     */
    public static FirstStep create() {
        return new PreferencesFactoryImpl();
    }
    
    /**
     * In this first step the developer have the possibility to activate the 
     * {@code application} or the {@code module} scope for this factory.
     * <p>
     * The different between both scopes is that
     * <ul>
     * <li>the used {@code key} in the {@code application} scope from the next 
     *     {@code SecondStep} must be <b>unique</b> in the <i>hole</i> application.</li>
     * <li>while the {@code key} in the {@code module} scope from the next 
     *     {@code SecondStep} must be <b>unique</b> in a <i>package</i> scope.</li>
     * </ul>
     * 
     * See the JavaDoc commenary from both methods in this interface for more information.
     * 
     * @since   0.6.0
     * @version 0.6.0
     * @author  Naoghuman
     */
    public interface FirstStep {
        
        /**
         * Activates the {@code application} scope.
         * <p>
         * In context from this scope a {@code key}, which allows to access or store a value
         * into the {@link java.util.Properties}, must be <b>unique</b> in the <i>hole</i> 
         * application.<br>
         * To accomplish this behavior this method adds automatically the prefix from the 
         * class {@link com.github.naoghuman.lib.preferences.internal.DefaultPreferences} to 
         * the given key.
         * 
         * @return  the next step in this factory: {@code SecondStep}
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#key(String)
         * @see     java.util.Properties
         */
        public SecondStep application();
        
        /**
         * Activates the {@code module} scope.
         * <p>
         * In context from this scope a {@code key}, which allows to access or store a value 
         * from / into the {@link java.util.Properties}, must be <b>unique</b> in a <i>package</i> 
         * scope.<br>
         * To accomplish this behavior this method adds automatically the {@code package name} 
         * from the {@code clazz} to the given key.
         * 
         * @param   clazz the package name from this {@code Class} defines the {@code module} scope.
         * @return  the next step in this factory: {@code SecondStep}
         * @throws  NullPointerException if {@code (clazz == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferences#key(String)
         * @see     com.github.naoghuman.lib.preferences.internal.DefaultPreferencesValidator#requireNonNull(java.lang.Object)
         * @see     java.lang.NullPointerException
         * @see     java.util.Properties
         */
        public SecondStep module(final Class clazz);
        
    }
    
    /**
     * In the second step from this factory the developer have to define the {@code key} 
     * which will then be used in the third step to {@code get(T)} or {@code put(T)} a 
     * {@code value}.
     * <p>
     * Hint:<br>
     * Be aware about the defined scope {@code (application || module)} in the first step 
     * from this factory, especially if the {@code key} exists in different scopes.
     * 
     * @since   0.6.0
     * @version 0.6.0
     * @author  Naoghuman
     */
    public interface SecondStep {
        
        /**
         * Defines the {@code key} which allowed in the third step from this factory 
         * to {@code get(T)} or {@code put(T)} a {@code value}.
         * <p>
         * Hint:<br>
         * Be aware about the defined scope {@code (application || module)} in the first step 
         * from this factory, especially if the {@code key} exists in different scopes.
         * 
         * @param   key the {@code key}.
         * @return  the next step in this factory: {@code ThirdStep}
         * @throws  IllegalArgumentException if {@code (key.trim() == EMPTY)}.
         * @throws  NullPointerException     if {@code (key        == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.IllegalArgumentException
         * @see     java.lang.NullPointerException
         */
        public ThirdStep key(final String key);
        
    }
    
    /**
     * The last step in this factory. In this step the developer can access or put the 
     * {@code value} through the defined {@code key} from the previous step.
     * <p>
     * In all {@code get(T)} methods the {@code default} value will returned if the 
     * {@code key} isn't found.<br>
     * In all {@code put(T)} methods the given {@code value} will be stored associated 
     * with the {@code key} in the previous choosen scope {@code (application / module)}.
     * 
     * @since   0.6.0
     * @version 0.6.0
     * @author  Naoghuman
     */
    public interface ThirdStep {
        
        /**
         * Returnes the associated {@code value} from the previous configured {@code key} in the 
         * choosen scope {@code (application / module)} or returned the {@code default} value if 
         * the key isn't found.
         * 
         * @param   def the default value which will be returned if the {@code key} isn't found.
         * @return  the associated {@code value} or {@code def}.
         * @throws  NullPointerException if {@code (def == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public Boolean get(final Boolean def);
        
        /**
         * Returnes the associated {@code value} from the previous configured {@code key} in the 
         * choosen scope {@code (application / module)} or returned the {@code default} value if 
         * the key isn't found.
         * 
         * @param   def the default value which will be returned if the {@code key} isn't found.
         * @return  the associated {@code value} or {@code def}.
         * @throws  NullPointerException if {@code (def == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public Double get(final Double def);
        
        /**
         * Returnes the associated {@code value} from the previous configured {@code key} in the 
         * choosen scope {@code (application / module)} or returned the {@code default} value if 
         * the key isn't found.
         * 
         * @param   def the default value which will be returned if the {@code key} isn't found.
         * @return  the associated {@code value} or {@code def}.
         * @throws  NullPointerException if {@code (def == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public Integer get(final Integer def);
        
        /**
         * Returnes the associated {@code value} from the previous configured {@code key} in the 
         * choosen scope {@code (application / module)} or returned the {@code default} value if 
         * the key isn't found.
         * 
         * @param   def the default value which will be returned if the {@code key} isn't found.
         * @return  the associated {@code value} or {@code def}.
         * @throws  NullPointerException if {@code (def == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public Long get(final Long def);
        
        /**
         * Returnes the associated {@code value} from the previous configured {@code key} in the 
         * choosen scope {@code (application / module)} or returned the {@code default} value if 
         * the key isn't found.
         * 
         * @param   def the default value which will be returned if the {@code key} isn't found.
         * @return  the associated {@code value} or {@code def}.
         * @throws  IllegalArgumentException if {@code (def.trim() == EMPTY)}.
         * @throws  NullPointerException     if {@code (def == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.IllegalArgumentException
         * @see     java.lang.NullPointerException
         */
        public String get(final String def);
        
        /**
         * Stores the given {@code value} in context from the previous configured scope 
         * {@code (application / module)} and defined {@code key}.
         * 
         * @param   value which will stored in context from the given scope {@code (application / module)}.
         * @throws  NullPointerException if {@code (value == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public void put(final Boolean value);
        
        /**
         * Stores the given {@code value} in context from the previous configured scope 
         * {@code (application / module)} and defined {@code key}.
         * 
         * @param   value which will stored in context from the given scope {@code (application / module)}.
         * @throws  NullPointerException if {@code (value == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public void put(final Double value);
        
        /**
         * Stores the given {@code value} in context from the previous configured scope 
         * {@code (application / module)} and defined {@code key}.
         * 
         * @param   value which will stored in context from the given scope {@code (application / module)}.
         * @throws  NullPointerException if {@code (value == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public void put(final Integer value);
        
        /**
         * Stores the given {@code value} in context from the previous configured scope 
         * {@code (application / module)} and defined {@code key}.
         * 
         * @param   value which will stored in context from the given scope {@code (application / module)}.
         * @throws  NullPointerException if {@code (value == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.NullPointerException
         */
        public void put(final Long value);
        
        /**
         * Stores the given {@code value} in context from the previous configured scope 
         * {@code (application / module)} and defined {@code key}.
         * 
         * @param   value which will stored in context from the given scope {@code (application / module)}.
         * @throws  IllegalArgumentException if {@code (value.trim() == EMPTY)}.
         * @throws  NullPointerException     if {@code (value        == NULL)}.
         * @since   0.6.0
         * @version 0.6.0
         * @author  Naoghuman
         * @see     java.lang.IllegalArgumentException
         * @see     java.lang.NullPointerException
         */
        public void put(final String value);
        
    }
    
    private static final class PreferencesFactoryImpl implements 
            FirstStep, SecondStep, ThirdStep
    {
        private DefaultPreferences preferences;
        
        PreferencesFactoryImpl() {
            this.initialize();
        }
        
        
        private void initialize() {
            LoggerFacade.getDefault().info(this.getClass(), "PreferencesFactoryImpl.initialize()"); // NOI18N
        
            preferences = new DefaultPreferences();
        }

        @Override
        public SecondStep application() {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.application()"); // NOI18N
        
            preferences.application();
            return this;
        }

        @Override
        public SecondStep module(final Class clazz) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.module(Class)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(clazz);
            preferences.module(clazz);
            
            return this;
        }

        @Override
        public ThirdStep key(final String key) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.key(String)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNullAndNotEmpty(key);
            preferences.key(key);
            
            return this;
        }

        @Override
        public Boolean get(final Boolean def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.get(Boolean)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public Double get(final Double def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.get(Double)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public Integer get(final Integer def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.get(Integer)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public Long get(final Long def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.get(Long)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(def);
            return preferences.get(def);
        }

        @Override
        public String get(final String def) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.get(String)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNullAndNotEmpty(def);
            return preferences.get(def);
        }

        @Override
        public void put(final Boolean value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.put(Boolean)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final Double value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.put(Double)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final Integer value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.put(Integer)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final Long value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.put(Long)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNull(value);
            preferences.put(value);
        }

        @Override
        public void put(final String value) {
            LoggerFacade.getDefault().debug(this.getClass(), "PreferencesFactoryImpl.put(String)"); // NOI18N
        
            DefaultPreferencesValidator.requireNonNullAndNotEmpty(value);
            preferences.put(value);
        }
        
    }
    
}
