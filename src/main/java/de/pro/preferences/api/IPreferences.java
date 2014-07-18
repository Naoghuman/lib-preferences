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
package de.pro.preferences.api;

import java.util.prefs.Preferences;
import javafx.scene.paint.Color;

/**
 * Die Anzahl der Format-Spezifizierer ist so groß und vielfältig, dass ein 
 * Blick in die API-Dokumentation auf jeden Fall von Nutzen ist. Wichtige 
 * Format-Spezifizierer sind:<p />
 * 
 * %n 	Neue Zeile<br />
 * %b 	Boolean<br />
 * %% 	Prozentzeichen<br />
 * %s 	String<br />
 * %c 	Unicode-Zeichen<br />
 * %d 	Dezimalzahl<br />
 * %x 	Hexadezimal<br />
 * %t 	Datum und Zeit<br />
 * %f 	Fließkommazahl<br />
 * %e 	Wissenschaftliche Notation<p />
 * 
 * IMPORTANT ADVICE:
 * Add Listener for changes with PauseTransition so only every changes with 
 * 250ms delay will register. For example for divider or slider.
 * 
 * @author PRo
 */
public interface IPreferences {
    // System
    public static final String SYSTEM_APPLICATION_HEIGHT = "SYSTEM_APPLICATION_HEIGHT"; // NOI18N
    public static final Double SYSTEM_APPLICATION_HEIGHT_DEFAULT_VALUE = 720.0d;
    public static final String SYSTEM_APPLICATION_WIDTH = "SYSTEM_APPLICATION_WIDTH";  // NOI18N
    public static final Double SYSTEM_APPLICATION_WIDTH_DEFAULT_VALUE = 1280.0d;
    
    public static final String SYSTEM_APPLICATION__VERSION = "SYSTEM_APPLICATION__VERSION";  // NOI18N
    public static final String SYSTEM_APPLICATION__VERSION_DEFAULT_VALUE = "v0.0.0";  // NOI18N
    
    public static final String SYSTEM_PREFERENCES__FILE = "SYSTEM_PREFERENCES__FILE"; // NOI18N
    public static final String SYSTEM_PREFERENCES__FILE_DEFAULT_VALUE = "Preferences.properties"; // NOI18N
    
    // System ToolBar
    public static final String SYSTEM_TOOLBAR_ANIMATION__BUTTONS = "SYSTEM_TOOLBAR_ANIMATION__BUTTONS"; // NOI18N
    public static final String SYSTEM_TOOLBAR_ANIMATION__BUTTONS_DEFAULT_VALUE = "dbw.view.animation.submenu.concentration"; // NOI18N
    public static final String SYSTEM_TOOLBAR_ANIMATION__SHOW_IT = "SYSTEM_TOOLBAR_ANIMATION__SHOW_IT"; // NOI18N
    public static final Boolean SYSTEM_TOOLBAR_ANIMATION__SHOW_IT_DEFAULT_VALUE = Boolean.TRUE;
    
    public static final String SYSTEM_TOOLBAR_CONFIGURATION__BUTTONS = "SYSTEM_TOOLBAR_CONFIGURATION__BUTTONS"; // NOI18N
    public static final String SYSTEM_TOOLBAR_CONFIGURATION__BUTTONS_DEFAULT_VALUE = "dbw.view.configuration.submenu.wallpaper"; // NOI18N
    public static final String SYSTEM_TOOLBAR_CONFIGURATION__SHOW_IT = "SYSTEM_TOOLBAR_CONFIGURATION__SHOW_IT"; // NOI18N
    public static final Boolean SYSTEM_TOOLBAR_CONFIGURATION__SHOW_IT_DEFAULT_VALUE = Boolean.TRUE;
    
    public static final String SYSTEM_TOOLBAR_FILE__BUTTONS = "SYSTEM_TOOLBAR_FILE__BUTTONS"; // NOI18N
    public static final String SYSTEM_TOOLBAR_FILE__BUTTONS_DEFAULT_VALUE = "dbw.view.file.submenu.dream;dbw.view.file.submenu.exercise"; // NOI18N
    public static final String SYSTEM_TOOLBAR_FILE__SHOW_IT = "SYSTEM_TOOLBAR_FILE__SHOW_IT"; // NOI18N
    public static final Boolean SYSTEM_TOOLBAR_FILE__SHOW_IT_DEFAULT_VALUE = Boolean.TRUE;
    
    public static final String SYSTEM_TOOLBAR_HELP__BUTTONS = "SYSTEM_TOOLBAR_HELP__BUTTONS"; // NOI18N
    public static final String SYSTEM_TOOLBAR_HELP__BUTTONS_DEFAULT_VALUE = "dbw.view.help.submenu.tipofthenight;dbw.view.help.submenu.welcome"; // NOI18N
    public static final String SYSTEM_TOOLBAR_HELP__SHOW_IT = "SYSTEM_TOOLBAR_HELP__SHOW_IT"; // NOI18N
    public static final Boolean SYSTEM_TOOLBAR_HELP__SHOW_IT_DEFAULT_VALUE = Boolean.TRUE;
    
    public static final String SYSTEM_TOOLBAR_TOOLS__BUTTONS = "SYSTEM_TOOLBAR_TOOLS__BUTTONS"; // NOI18N
    public static final String SYSTEM_TOOLBAR_TOOLS__BUTTONS_DEFAULT_VALUE = "dbw.view.tools.submenu.counter"; // NOI18N
    public static final String SYSTEM_TOOLBAR_TOOLS__SHOW_IT = "SYSTEM_TOOLBAR_TOOLS__SHOW_IT"; // NOI18N
    public static final Boolean SYSTEM_TOOLBAR_TOOLS__SHOW_IT_DEFAULT_VALUE = Boolean.TRUE;
    
    // Helper Window
//    public static final String HELPER_WINDOW__TIPOFTHENIGHT__SHOW_FROM_START = "HELPER_WINDOW__TIPOFTHENIGHT__SHOW_FROM_START"; // NOI18N
//    public static final Boolean HELPER_WINDOW__TIPOFTHENIGHT__SHOW_FROM_START_DEFAULT_VALUE = Boolean.FALSE;
    
    // View
    public static final String VIEW__DIVIDER_POSITION = "VIEW__DIVIDER_POSITION"; // NOI18N
    public static final Double VIEW__DIVIDER_POSITION_DEFAULT_VALUE = 0.25d;
    
    // View Animation
    public static final String MODULE_ANIMATION_CONCENTRATION__SHOW_IT = "MODULE_ANIMATION_CONCENTRATION__SHOW_IT"; // NOI18N
    public static final Boolean MODULE_ANIMATION_CONCENTRATION__SHOW_IT_DEFAULT_VALUE = Boolean.FALSE;
    
    public static final String MODULE_ANIMATION_CONCENTRATION__COLOR = "MODULE_ANIMATION_CONCENTRATION__COLOR"; // NOI18N
    public static final Color MODULE_ANIMATION_CONCENTRATION__COLOR_DEFAULT_VALUE = Color.YELLOWGREEN;
    
    public static final String MODULE_ANIMATION_CONCENTRATION__DROPSHADOW_COLOR = "MODULE_ANIMATION_CONCENTRATION__DROPSHADOW_COLOR"; // NOI18N
    public static final Color MODULE_ANIMATION_CONCENTRATION__DROPSHADOW_COLOR_DEFAULT_VALUE = Color.BLACK;
    public static final String MODULE_ANIMATION_CONCENTRATION__DROPSHADOW_IS_VISIBLE = "MODULE_ANIMATION_CONCENTRATION__DROPSHADOW_IS_VISIBLE"; // NOI18N
    public static final Boolean MODULE_ANIMATION_CONCENTRATION__DROPSHADOW_IS_VISIBLE_DEFAULT_VALUE = Boolean.FALSE;
    
    public static final String MODULE_ANIMATION_CONCENTRATION__OPACITY = "MODULE_ANIMATION_CONCENTRATION__OPACITY"; // NOI18N
    public static final Double MODULE_ANIMATION_CONCENTRATION__OPACITY_DEFAULT_VALUE = 0.25d;
    
    public static final String MODULE_ANIMATION_CONCENTRATION__PAUSE_MAX_IS_DISABLE = "MODULE_ANIMATION_CONCENTRATION__PAUSE_MAX_IS_DISABLE"; // NOI18N
    public static final Boolean MODULE_ANIMATION_CONCENTRATION__PAUSE_MAX_IS_DISABLE_DEFAULT_VALUE = Boolean.FALSE;
    public static final String MODULE_ANIMATION_CONCENTRATION__PAUSE_MAX_DURATION = "MODULE_ANIMATION_CONCENTRATION__PAUSE_MAX_DURATION"; // NOI18N
    public static final Double MODULE_ANIMATION_CONCENTRATION__PAUSE_MAX_DURATION_DEFAULT_VALUE = 2.5d;
    
    public static final String MODULE_ANIMATION_CONCENTRATION__PAUSE_MIN_IS_DISABLE = "MODULE_ANIMATION_CONCENTRATION__PAUSE_MIN_IS_DISABLE"; // NOI18N
    public static final Boolean MODULE_ANIMATION_CONCENTRATION__PAUSE_MIN_IS_DISABLE_DEFAULT_VALUE = Boolean.FALSE;
    public static final String MODULE_ANIMATION_CONCENTRATION__PAUSE_MIN_DURATION = "MODULE_ANIMATION_CONCENTRATION__PAUSE_MIN_DURATION"; // NOI18N
    public static final Double MODULE_ANIMATION_CONCENTRATION__PAUSE_MIN_DURATION_DEFAULT_VALUE = 1.0d;
    
    public static final String MODULE_ANIMATION_CONCENTRATION__STROKE_WIDTH = "MODULE_ANIMATION_CONCENTRATION__STROKE_WIDTH"; // NOI18N
    public static final Double MODULE_ANIMATION_CONCENTRATION__STROKE_WIDTH_DEFAULT_VALUE = 1.0d;
    
    // View Background, default value -> IResources
    public static final String VIEW_CONFIGURATION_WALLPAPER__IMAGE = "VIEW_CONFIGURATION_WALLPAPER__IMAGE"; // NOI18N
    public static final String VIEW_CONFIGURATION_WALLPAPER__IMAGE_DEFAULT_VALUE = "wallpaper_1.jpg"; // NOI18N
    
    // View Navigator
    public static final String VIEW_NAVIGATOR = "VIEW_NAVIGATOR"; // NOI18N
    public static final Integer VIEW_NAVIAGATOR__DEFAULT_VALUE = 0;
    
    public Boolean getBoolean(String key, Boolean def);
    public Boolean getBoolean(Class clazz, String key, Boolean def);
    public void putBoolean(String key, Boolean value);
    public void putBoolean(Class clazz, String key, Boolean value);
    
    public String get(String key, String def);
    public String get(Class clazz, String key, String def);
    public void put(String key, String value);
    public void put(Class clazz, String key, String value);
    
    public Double getDouble( String key, Double def);
    public Double getDouble(Class clazz, String key, Double def);
    public void putDouble(String key, Double value);
    public void putDouble(Class clazz, String key, Double value);
    
    public Integer getInt(String key, Integer def);
    public Integer getInt(Class clazz, String key, Integer def);
    public void putInt(String key, Integer value);
    public void putInt(Class clazz, String key, Integer value);
    
    public void init(Boolean shouldDeletePreferences);
    public Preferences forApplication();
    public Preferences forModule(final Class clazz);
}
