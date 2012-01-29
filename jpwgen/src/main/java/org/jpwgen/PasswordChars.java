// Copyright (c) Andrew Smith. All rights reserved.
// The use and distribution terms for this software are covered by the
// Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
// which can be found in the file epl-v10.html at the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by
// the terms of this license.
// You must not remove this notice, or any other, from this software.
package org.jpwgen;

// PasswordChars holds the type of characters available
// to the password generator.
public class PasswordChars {

    private final boolean alphaLower;
    private final boolean alphaUpper;
    private final boolean numeric;
    private final boolean punctuation;

    public PasswordChars(final boolean alphaLower, final boolean alphaUpper,
            final boolean numeric, final boolean punctuation) {

        this.alphaLower = alphaLower;
        this.alphaUpper = alphaUpper;
        this.numeric = numeric;
        this.punctuation = punctuation;
    }

    public boolean getAlphaLower() {
        return alphaLower;
    }

    public boolean getAlphaUpper() {
        return alphaUpper;
    }

    public boolean getNumeric() {
        return numeric;
    }

    public boolean getPunctuation() {
        return punctuation;
    }
}