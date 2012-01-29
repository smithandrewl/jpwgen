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

    private static final String lookupTable = "abcdefghijklmnopqrstuvwxyz"
            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890"
            + "`~!@#$%^&*()_+[]{};:'\",<.>/?|\\";

    private final Random random;

    private static final boolean isAlphaLower(final int index) {
        return (index >= 0) && (index <= 25);
    }

    private static final boolean isAlphaUpper(final int index) {
        return (index >= 26) && (index <= 51);
    }

    private static final boolean isNumeric(final int index) {
        return (index >= 52) && (index <= 61);
    }

    private static final boolean isPunctuation(final int index) {
        return (index >= 62) && (index <= 94);
    }

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
        final StringBuffer password = new StringBuffer(length);

        while (password.length() < length) {

            // Generate a random value between 0 and the size of the lookup
            // table.
            final int value = random.nextInt(lookupTable.length());

            // if it is a type specified in the PasswordCharacters instance,
            // fetch the character from the lookup table and add it to the
            // password
            if ((isAlphaLower(value) && characters.getAlphaLower())
                    || (isAlphaUpper(value) && characters.getAlphaUpper())
                    || (isNumeric(value) && characters.getNumeric())
                    || (isPunctuation(value) && characters.getPunctuation())) {
                password.append(lookupTable.charAt(value));
            }
        }
        return password.toString();
    }

}
