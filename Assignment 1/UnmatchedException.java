/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: A utility class for checking passwords with only static methods.
 * Due: 2.6.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class UnmatchedException extends Exception{
    //The Word document provided says the message should be "The passwords do not match" but the PasswordCheckerTestPublic does not have a "The"
    public UnmatchedException(){
        super("Passwords do not match");
    }
}
