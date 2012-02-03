// Copyright (c) Andrew Smith. All rights reserved.
// The use and distribution terms for this software are covered by the
// Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
// which can be found in the file epl-v10.html at the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by
// the terms of this license.
// You must not remove this notice, or any other, from this software.
package org.jpwgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "1234567890";
    private static final String PUNCTUATION = "`~!@#$%^&*()_+[]{};:'\",<.>/?|\\";
    
    private final Random random;

    public PasswordGenerator(Random random) {
        this.random = random;
    }

    public List<String> generateMultiple(PasswordChars characters, int number,
            int length) {
        final List<String> result = new ArrayList<String>(number);

        for (int i = 0; i < number; i++) {
            result.add(generate(characters, length));
        }
        return result;
    }

    public String generate(PasswordChars characters, int length) {
        
        String lookupTable="";
        
        if(characters.getAlphaLower()) {
            lookupTable += LOWER;
        }
        
        if(characters.getAlphaUpper()) {
            lookupTable += UPPER;
        }
        
        if(characters.getNumeric()) {
            lookupTable += NUMERIC;
        }
        
        if(characters.getPunctuation()) {
            lookupTable += PUNCTUATION;
        }
        
        final StringBuffer password = new StringBuffer(length);

        for(int i = 0; i<length; i++ ) {

            // Generate a random value between 0 and the size of the lookup
            // table.
            final int value = random.nextInt(lookupTable.length());

            password.append(lookupTable.charAt(value));
            
        }
        
        return password.toString();
    }

}
