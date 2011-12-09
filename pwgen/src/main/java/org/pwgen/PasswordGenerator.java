package org.pwgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    private static final String lookupTable = 
	      "abcdefghijklmnopqrstuvwxyz"
	    + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" 
            + "1234567890"
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
    
    public PasswordGenerator() {
	random = new Random();
    }
    
    public PasswordGenerator(long seed) {
	random = new Random(seed);
    }

    public List<String> generateMultiple(PasswordChars characters, int number, int length) {
	final List<String> result = new ArrayList<String>(number);
	
	for (int i = 0; i < number; i++) {
	    result.add(generate(characters, length));
	}
	return result;
    }
    
    public String generate(PasswordChars characters, int length) {
	final StringBuffer password = new StringBuffer(length);
	    
	    while (password.length() < length) {

		final int value = random.nextInt(lookupTable.length());

		// Generate a random character and add it to the password if it is a type
		// specified in the PasswordCharacters instance.
		if ((isAlphaLower(value) && characters.getAlphaLower())
			|| (isAlphaUpper(value)  && characters.getAlphaUpper())
			|| (isNumeric(value)     && characters.getNumeric())
			|| (isPunctuation(value) && characters.getPunctuation())) {
		    password.append(lookupTable.charAt(value));
		}
	    }
	    return password.toString();
    }
    
}
