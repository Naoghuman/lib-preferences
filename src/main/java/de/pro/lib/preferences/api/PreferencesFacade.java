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

import de.pro.lib.preferences.PRoPreferences;

/**
 * The facade {@link de.pro.lib.preferences.api.PreferencesFacade} provides a 
 * singleton instance of the Interface {@link de.pro.lib.preferences.api.IPreferences}.
 *
 * @author PRo
 * @see de.pro.lib.preferences.api.IPreferences
 */
public final class PreferencesFacade {
    
    private static IPreferences instance = null;
    
    /**
     * Provides a singleton instance from the Interface {@link de.pro.lib.preferences.api.IPreferences}.
     * 
     * @return A singleton instance of{@link de.pro.lib.preferences.api.IPreferences}.
     * @see de.pro.lib.preferences.api.IPreferences
     */
    public static IPreferences getDefault() {
        
        if (instance == null) {
            instance = new PRoPreferences();
        }
        
        return instance;
    }
    
    private PreferencesFacade() { }
}
