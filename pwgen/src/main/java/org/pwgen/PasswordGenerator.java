package org.pwgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    private final PasswordChars characters;
    private final int length;
    private final int number;

    private static final String lookupTable = 
	      "abcdefghijklmnopqrstuvwxyz"
	    + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" 
            + "1234567890"
	    + "`~!@#$%^&*()_+[]{};:'\",<.>/?|\\";
    
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
    
    //TODO: 
    // Refactor: 
    //   * Move the characters and length parameters to the generate
    //     method.  
    //   * Modify generate to generate a single password
    //   * Add a method named generateMultiple which should take characters
    //     length and number parameters and return a List of String.
    //   * Overload the default constructor to take no parameters and initialize the random number
    //     generator.
    //   * Add a constructor overload which should take a long to seed the random number generator with.
    public PasswordGenerator(final PasswordChars characters, final int length, final int number) {
	this.characters = characters;
	this.length = length;
	this.number = number;
    }

    public List<String> generate() {
	final List<String> result = new ArrayList<String>(number);
	final Random random = new Random();
	for (int i = 0; i < number; i++) {

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
	    result.add(password.toString());
	}
	return result;
    }
}
