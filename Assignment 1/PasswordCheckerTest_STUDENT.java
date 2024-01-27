
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author
 *
 */
public class PasswordCheckerTest_STUDENT {
    ArrayList<String> passwords;
    @Before
    public void setUp() throws Exception {
        passwords = new ArrayList<String>();
        passwords.add("test");
        passwords.add("L2D");
        passwords.add("scoobyDoo@123");
        passwords.add("Pom2#");
        passwords.add("Dlx20999$");
    }

    @After
    public void tearDown() throws Exception {
       passwords = null;
    }

    /**
     * Test if the password is less than 6 characters long.
     * This test should throw a LengthException for second case.
     */
    @Test
    public void testIsValidPasswordTooShort()
    {
        for(String s : passwords) {
            boolean temp = s.equals("scoobyDoo@123") || s.equals("Dlx20999$");
            try {
                if(temp) {
                    assertTrue(PasswordCheckerUtility.isValidLength(s));
                } else {
                    assertFalse(PasswordCheckerUtility.isValidLength(s));
                }

            } catch(LengthException e) {
                if(temp) {
                    fail("Should be true");
                } else {
                    assertTrue("Passed", true);
                }
            }
        }
    }

    /**
     * Test if the password has at least one uppercase alpha character
     * This test should throw a NoUpperAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoUpperAlpha()
    {
        for(String s : passwords){
            boolean temp = s.equals("L2D") || s.equals("scoobyDoo@123") || s.equals("Pom2#") || s.equals("Dlx20999$");
            try{
                if(temp) {
                    assertTrue(PasswordCheckerUtility.hasUpperAlpha(s));
                }else{
                    assertFalse(PasswordCheckerUtility.hasUpperAlpha(s));
                }
            }catch(NoUpperAlphaException e){
                if(temp) {
                    fail("Should be true");
                }else {
                    assertTrue("Passed", true);
                }
            }
        }
    }

    /**
     * Test if the password has at least one lowercase alpha character
     * This test should throw a NoLowerAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoLowerAlpha()
    {
        for(String s : passwords){
            boolean temp = s.equals("l2D");
            try{
                if(temp){
                    PasswordCheckerUtility.hasLowerAlpha(s);
                }else{
                    assertTrue(PasswordCheckerUtility.hasLowerAlpha(s));
                }
            }catch(NoLowerAlphaException e){
                if(temp){
                    fail("This should be true");
                }else {
                    assertTrue("Passed", true);
                }
            }
        }
    }
    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsWeakPassword()
    {
        for(String s : passwords){
            boolean temp = s.equals("scoobyDoo@123");
            try{
                boolean weak = PasswordCheckerUtility.isWeakPassword(s);
                if(temp){
                    assertFalse(weak);
                }
            }catch(WeakPasswordException e){
                if(temp){
                    fail("This should be false above");
                }else {
                    assertTrue("Passed", true);
                }
            }
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsValidPasswordInvalidSequence() {

    }

    /**
     * Test if the password has at least one digit
     * One test should throw a NoDigitException
     */
    @Test
    public void testIsValidPasswordNoDigit()
    {
        for(String s : passwords){
            boolean temp = s.equals("test");
            try{
                if(temp){
                    assertFalse(PasswordCheckerUtility.hasDigital(s));
                }else{
                    assertTrue(PasswordCheckerUtility.hasDigital(s));
                }
            }catch(NoDigitException e){
                if(temp){
                    assertTrue("Passed", true);
                }else{
                    fail("This should be true");
                }
            }
        }
    }

    /**
     * Test correct passwords
     * This test should not throw an exception
     */
    @Test
    public void testIsValidPasswordSuccessful()
    {
        for(String s : passwords){
            boolean temp = s.equals("scoobyDoo@123");
            try{
                if(temp){
                    assertTrue(PasswordCheckerUtility.isValidPassword(s));
                }else{
                    assertFalse(PasswordCheckerUtility.isValidPassword(s));
                }
            }catch(Exception e){
                if(temp){
                    fail("This should be true");
                }else{
                    assertTrue("Passed", true);
                }
            }
        }
    }

    /**
     * Test the invalidPasswords method
     * Check the results of the ArrayList of Strings returned by the validPasswords method
     */
    @Test
    public void testInvalidPasswords() {
        ArrayList<String> validPasswords = new ArrayList<>();
        validPasswords.add("test The password must be at least 6 characters long");
        validPasswords.add("L2D The password must be at least 6 characters long");
        validPasswords.add("Pom2# The password must be at least 6 characters long");
        validPasswords.add("Dlx20999$ The password cannot contain more than two of the same character in sequence.");
        assertEquals(validPasswords, PasswordCheckerUtility.getInvalidPasswords(passwords));
    }

}
