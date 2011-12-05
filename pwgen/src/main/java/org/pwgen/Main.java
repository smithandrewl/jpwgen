package org.pwgen;

public class Main {
    private final PasswordGenerator generator;
    
    public Main(PasswordGenerator generator) {
	this.generator = generator;
    }
    
    public void run() {
	for (String password : generator.generate()) {
	    System.out.println(password);
	}
    }
    
    // TODO: Use Apache Commons Cli to get password and character options.
    public static void main(String[] args) {
	
	PasswordChars options = new PasswordChars(false, false, false, true);
	
	PasswordGenerator generator = new PasswordGenerator(options, 30, 10);
	
	Main program = new Main(generator);
	program.run();
    }

}
