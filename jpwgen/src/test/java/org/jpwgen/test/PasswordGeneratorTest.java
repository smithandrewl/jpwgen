package org.jpwgen.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.jpwgen.PasswordChars;
import org.jpwgen.PasswordGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordGeneratorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGenerateMultipleLength() {
        PasswordGenerator generator = new PasswordGenerator(new Random());
        PasswordChars characters = new PasswordChars(true,true, true, true);
        
        List<String> result = generator.generateMultiple(characters, 10, 10);
        
        for(String password : result) {
            assertEquals(10, password.length());
        }
    }
}
