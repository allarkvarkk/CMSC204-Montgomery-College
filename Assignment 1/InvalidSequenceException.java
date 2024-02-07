/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Exception for 3 or more characters in sequence
 * Due: 2.6.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class InvalidSequenceException extends Exception{
    public InvalidSequenceException(){
        super("The password cannot contain more than two of the same character in sequence.");
    }
}
