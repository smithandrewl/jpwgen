package org.pwgen;

// PasswordChars holds the type of characters available
// to the password generator.
public class PasswordChars {

    private final boolean alphaLower;
    private final boolean alphaUpper;
    private final boolean numeric;
    private final boolean punctuation;

    public PasswordChars(final boolean alphaLower, 
	    		      final boolean alphaUpper,
	                      final boolean numeric, 
	                      final boolean punctuation) {
	
	this.alphaLower  = alphaLower;
	this.alphaUpper  = alphaUpper;
	this.numeric     = numeric;
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