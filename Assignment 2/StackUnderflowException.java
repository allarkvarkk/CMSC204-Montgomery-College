/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: Exception for the stack to prevent going under 0 elements
 * Due: 2.22.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
public class StackUnderflowException extends Exception{
    public StackUnderflowException(){
        super("stack underflow");
    }
}
