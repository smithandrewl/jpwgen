package org.pwgen;

public class Main {
    // TODO: Use Apache Commons Cli to get password and character options.
    public static void main(String[] args) {
	PasswordGenerator generator = new PasswordGenerator();
	
	PasswordChars options = new PasswordChars(true, true, true, false);
	final int number = 10;
	final int length = 10;
	
	for (String password : generator.generateMultiple(options, number, length)) {
	    System.out.println(password);
	}
    }

}
