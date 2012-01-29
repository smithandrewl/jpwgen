package org.jpwgen.test;

import static org.junit.Assert.*;
import org.jpwgen.*;

import org.junit.Test;

public class PasswordCharsTest {

    
    
    @Test
    public void testUppercase() {
        PasswordChars upper = new PasswordChars(false, true,false, false);  
        
        assertTrue(upper.getAlphaUpper());
    }
    
    @Test
    public void testLowercase() {
        PasswordChars lower = new PasswordChars(true, false, false, false);
        
        assertTrue(lower.getAlphaLower());
    }
    
    @Test
    public void testNumeric() {
        PasswordChars numeric = new PasswordChars(false, false, true, false);
        
        assertTrue(numeric.getNumeric());
    }
    
    @Test 
    public void testPunctuation() {
        PasswordChars punctuation = new PasswordChars(false, false, false, true);
    
        assertTrue(punctuation.getPunctuation());
    }

}
