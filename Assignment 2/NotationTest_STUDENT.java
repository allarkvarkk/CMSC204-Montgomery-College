/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: JUnit test for the notation class
 * Due: 2.22.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotationTest_STUDENT {
    private String[] postfix, infix;
    private String invalidPostfix, invalidInfix;
    private double[] values;
    @BeforeEach
    void setUp() {
        postfix = new String[5];
        infix = new String[5];
        values = new double[5];
        postfix[0] = "1559+2*+4*4*8**3+";
        postfix[1] = "4699+2+4***";
        postfix[2] = "29+0*22-42*2+2*++2-4+23*+";
        postfix[3] = "8888889******24+98*2365///*--";
        postfix[4] = "229/*2+1-992+-2*+33*13/*13/*+";
        infix[0] = "((1*((((5+((5+9)*2))*4)*4)*8))+3)";
        infix[1] = "(4*(6*(((9+9)+2)*4)))";
        infix[2] = "((2+9)*0)+((2-2)+((4*2)+2)*2)-2+4+(2*3)";
        infix[3] = "(8*(8*(8*(8*(8*(8*9))))))-((2+4)-(9*8)*(2/(3/(6/5))))";
        infix[4] = "(2*(2/9))+2-1+((9-(9+2))*2) + (((3*3)*(1/3))*(1/3))";
        invalidPostfix = "32+23/*2+(";
        invalidInfix = "(3+2)*(2/3))";
        values[0] = 4227;
        values[1] = 1920;
        values[2] = 28;
        values[3] = 2359347.6;
        values[4] = -1.5;
    }

    @AfterEach
    void tearDown() {
        postfix = infix = null;
        invalidInfix = invalidPostfix = null;
        values = null;
    }

    @Test
    void evaluatePostfixExpression() {
        for(int i = 0; i < values.length; i ++){
            try{
                assertEquals(values[i], Notation.evaluatePostfixExpression(postfix[i]), 0.1);
            }catch(InvalidNotationFormatException e){
                System.out.println(i);
                fail("Should not throw exception");
            }
        }
    }

    @Test
    void convertPostfixToInfix() {
        for(int i = 0; i < 5; i ++) {
            try {
                assertEquals(infix[0], Notation.convertPostfixToInfix(postfix[0]));
            }catch(InvalidNotationFormatException e){
                fail("");
            }
        }
        try {
            Notation.convertPostfixToInfix(invalidPostfix);
            fail("Should throw exception");
        }catch(InvalidNotationFormatException e){
        }
    }

    @Test
    void convertInfixToPostfix() {
        for(int i = 0; i < 5; i ++){
            try{
                assertEquals(postfix[0], Notation.convertInfixToPostfix(infix[0]));
            }catch(InvalidNotationFormatException e){
                fail(" ");
            }
        }
        try{
            Notation.convertInfixToPostfix(invalidInfix);
            fail("Should throw exception");
        }catch(InvalidNotationFormatException e){
        }
    }
}