/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Exception if passwords hae no special characters (no letters or vowels)
 * Due: 2.6.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class NoSpecialCharacterException extends Exception{
    public NoSpecialCharacterException(){
        super("The password must contain at least one special character");
    }
}
