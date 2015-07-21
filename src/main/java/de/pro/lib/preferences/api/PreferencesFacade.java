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
package de.pro.lib.preferences.api;

import de.pro.lib.preferences.LibPreferences;

/**
 * The facade {@link de.pro.lib.preferences.api.PreferencesFacade} provides 
 * access to the Interface {@link de.pro.lib.preferences.api.ILibPreferences}.
 *
 * @author PRo
 * @see de.pro.lib.preferences.api.ILibPreferences
 */
public enum PreferencesFacade {
    
    /**
     * Over the value <code>INSTANCE</code> the developer have access to the
     * singleton instance from the <code>PreferencesFacade</code>.
     */
    INSTANCE;
    
    private ILibPreferences preferences = null;
    
    private PreferencesFacade() {
        this.initialize();
    }
    
    private void initialize() {
        preferences = new LibPreferences();
    }
    
    /**
     * Over the {@link de.pro.lib.preferences.api.ILibPreferences} the developer
     * have access to the preferences methods.
     * 
     * @return a singleton instance from ILibPreferences.
     */
    public ILibPreferences getPreferences() {
        return preferences;
    }
 
}
