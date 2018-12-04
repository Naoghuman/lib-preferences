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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

/**
 * This class extend the class {@link java.util.Properties} with the goal to overwrite 
 * the original method {@link java.util.Properties#store(java.io.OutputStream, java.lang.String)}.
 * <p>
 * During the overwriting a new header will be created in the overwritten method with the 
 * following format:<br>
 * ################################################################################<br>
 * #<br>
 * # {@code comment}<br>
 * # {@code new Date().toString()}<br>
 * #<br>
 * ################################################################################
 *
 * @author Naoghuman
 * @since  0.6.0
 * @see    java.util.Properties
 * @see    java.util.Properties#store(java.io.OutputStream, java.lang.String)
 */
final class DefaultPreferencesProperties extends Properties {

    /* A table of hex digits */
    private static final char[] hexDigit = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', // NOI18N
        'A', 'B', 'C', 'D', 'E', 'F' // NOI18N
    };
    
    /*
     * Converts unicodes to encoded &#92;uxxxx and escapes
     * special characters with a preceding slash
     */
    private String saveConvert(final String theString, final boolean escapeSpace, final boolean escapeUnicode) {
        int len = theString.length();
        int bufLen = len * 2;
        if (bufLen < 0) {
            bufLen = Integer.MAX_VALUE;
        }
        
        final StringBuilder outBuffer = new StringBuilder(bufLen);
        for(int x = 0; x < len; x++) {
            char aChar = theString.charAt(x);
            // Handle common case first, selecting largest block that avoids the specials below
            if (
                    (aChar > 61)
                    && (aChar < 127))
            {
                if (aChar == '\\') { // NOI18N
                    outBuffer.append('\\').append('\\'); // NOI18N
                    continue;
                }
                
                outBuffer.append(aChar);
                continue;
            }
            
            switch(aChar) {
                case ' ': // NOI18N
                    if (x == 0 || escapeSpace)
                        outBuffer.append('\\'); // NOI18N
                    outBuffer.append(' '); // NOI18N
                    break;
                case '\t':outBuffer.append('\\'); outBuffer.append('t'); break; // NOI18N
                case '\n':outBuffer.append('\\'); outBuffer.append('n'); break; // NOI18N
                case '\r':outBuffer.append('\\'); outBuffer.append('r'); break; // NOI18N
                case '\f':outBuffer.append('\\'); outBuffer.append('f'); break; // NOI18N
                case '=': // NOI18N// Fall through
                case ':': // NOI18N// Fall through
                case '#': // NOI18N// Fall through
                case '!': // NOI18N
                    outBuffer.append('\\'); outBuffer.append(aChar); break; // NOI18N
                default:
                    if (
                            (
                                (aChar < 0x0020)
                                || (aChar > 0x007e))
                            & escapeUnicode )
                    {
                        outBuffer.append('\\'); // NOI18N
                        outBuffer.append('u');  // NOI18N
                        outBuffer.append(toHex((aChar >> 12) & 0xF));
                        outBuffer.append(toHex((aChar >>  8) & 0xF));
                        outBuffer.append(toHex((aChar >>  4) & 0xF));
                        outBuffer.append(toHex( aChar        & 0xF));
                    } else {
                        outBuffer.append(aChar);
                    }
            }
        }
        
        return outBuffer.toString();
    }
    
    @Override
    public void store(OutputStream out, String comment) throws IOException {
        DefaultPreferencesValidator.requireNonNull(out);
        DefaultPreferencesValidator.requireNonNullAndNotEmpty(comment);
        
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "8859_1")); // NOI18N
        writer.write("################################################################################"); // NOI18N
        writer.newLine();
        writer.write("#"); // NOI18N
        writer.newLine();
        
        this.write(writer, comment);
        
        writer.write("# " + new Date().toString()); // NOI18N
        writer.newLine();
        writer.write("#"); // NOI18N
        writer.newLine();
        writer.write("################################################################################"); // NOI18N
        writer.newLine();
        writer.newLine();
        
        synchronized (DefaultPreferencesProperties.this) {
            String key;
            String value;
            for (Enumeration<?> e = keys(); e.hasMoreElements();) {
                key   = (String) e.nextElement();
                value = (String) get(key);
                key   = this.saveConvert(key,   true,  true);
                value = this.saveConvert(value, false, true);
                
                writer.write(key + "=" + value); // NOI18N
                writer.newLine();
            }
        }
        
        writer.flush();
    }
    
    private void write(final BufferedWriter writer, String comments) throws IOException {
        writer.write("# "); // NOI18N
        
        int len = comments.length();
        int current = 0;
        int last = 0;
        char[] uu = new char[6];
        uu[0] = '\\'; // NOI18N
        uu[1] = 'u'; // NOI18N
        while (current < len) {
            char c = comments.charAt(current);
            if (
                    c > '\u00ff' // NOI18N
                    || c == '\n' // NOI18N
                    || c == '\r') // NOI18N
            {
                if (last != current) {
                    writer.write(comments.substring(last, current));
                }
                
                if (c > '\u00ff') { // NOI18N
                    uu[2] = toHex((c >> 12) & 0xf);
                    uu[3] = toHex((c >>  8) & 0xf);
                    uu[4] = toHex((c >>  4) & 0xf);
                    uu[5] = toHex( c        & 0xf);
                    writer.write(new String(uu));
                } else {
                    writer.newLine();
                    if (
                            c == '\r' // NOI18N
                            && current != len - 1
                            && comments.charAt(current + 1) == '\n') // NOI18N
                    {
                        current++;
                    }
                    
                    if (
                            current == len - 1
                            || (
                                    comments.charAt(current + 1) != '#' // NOI18N
                                &&  comments.charAt(current + 1) != '!') // NOI18N
                    ) {
                        writer.write("# "); // NOI18N
                    }
                }
                
                last = current + 1;
            }
            
            current++;
        }
        
        if (last != current) {
            writer.write(comments.substring(last, current));
        }
        
        writer.newLine();
    }
    
    /**
     * Convert a nibble to a hex character
     * @param   nibble  the nibble to convert.
     */
    private char toHex(int nibble) {
        return hexDigit[(nibble & 0xF)];
    }
    
}
