/*
 * Class: CMSC204 - 30377
 * Instructor: Khandan Vahabzadeh Monshi
 * Description: A class that converts math expressions (infix and postfix) as well as evaluates them
 * Due: 2.22.2024
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jacob Hauptman
*/
import java.util.ArrayList;

public class Notation {
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
        short numberCount = 0, operandCount = 0;
        for(int i = 0; i < postfixExpr.length(); i ++){
            char c = postfixExpr.charAt(i);
            if(Character.isDigit(c)){
                numberCount ++;
            }else{
                operandCount ++;
            }
        }
        if(numberCount != operandCount + 1){ //Since we are dealing with only single digits, there must be one more number than operand
            throw new InvalidNotationFormatException();
        }
        MyStack<Double> stack = new MyStack<>(postfixExpr.length()); //Stack that will only hold the numbers
        double[] values = new double[2]; //array that will hold the top 2 popped elements
        do {
            for (int i = 0; i < postfixExpr.length(); i++) {
                try {
                    char c = postfixExpr.charAt(i);
                    if (Character.isDigit(c)) {
                        stack.push(Double.parseDouble(String.valueOf(c)));
                    } else {
                        values[0] = stack.pop();
                        values[1] = stack.pop();
                        switch (c) { //enhanced switch to evaluate the current math expression
                            case '+' -> stack.push(values[1] + values[0]);
                            case '-' -> stack.push(values[1] - values[0]);
                            case '*' -> stack.push(values[1] * values[0]);
                            case '/' -> stack.push(values[1] / values[0]);
                        }
                    }
                } catch (StackOverflowException | StackUnderflowException e) {
                    throw new InvalidNotationFormatException();
                }
            }
        } while (stack.size() != 1); //If the stack size is 1, that means we have a final answer
        try{
            return stack.pop();
        } catch (StackUnderflowException e) {
            throw new InvalidNotationFormatException();
        }
    }
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
        StringBuilder sb = new StringBuilder();
        MyStack<String> stack = new MyStack<>(postfix.length());
        String[] topTwo = new String[2]; //array that will hold the top 2 popped elements
        try {
            for (int i = 0; i < postfix.length(); i++) {
                char c = postfix.charAt(i);
                if (Character.isDigit(c)) {
                    stack.push(String.valueOf(c));
                }else{
                    topTwo[0] = stack.pop();
                    topTwo[1] = stack.pop();
                    sb.append("(").append(topTwo[1]).append(c).append(topTwo[0]).append(")"); //puts operands in the middle of numbers and adds ()
                    stack.push(sb.toString()); //Push this expression
                    sb.delete(0,sb.length()); //clear the StringBuilder
                }
            }
            return stack.toString();
        }catch(StackOverflowException | StackUnderflowException e){
            throw new InvalidNotationFormatException();
        }
    }
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
        MyStack<String> stack = new MyStack<>(infix.length()); //This will hold the final expression
        ArrayList<Boolean> hasOpen = new ArrayList<>(); //Keeps track of how many open parenthesis there are "("
        MyStack<Character> operands = new MyStack<>(infix.length()); //Hold the operands
        try{
            for(int i = 0; i < infix.length(); i ++){
                char c = infix.charAt(i);
                if(!Character.isDigit(c)){
                    if(!operands.isEmpty()) {
                        char top = operands.top();
                        if ((top == c ||
                                ((top == '+' || top == '-') && (c == '+' || c == '-')) ||
                                ((top == '*' || top == '/') && (c == '*' || c == '/'))
                        ) && (top != '(' && top != ')')) { //checks if operands on top and current are equal or of same precedence
                            stack.push(String.valueOf(operands.pop())); //pop the operand from operands and add to stack
                        }
                    }

                    if(c == '('){
                        hasOpen.add(true);
                    }
                    if(c == ')' && !hasOpen.isEmpty()){ //check empty because otherwise there is not a matching "("
                        if(operands.top() != '(' && operands.top() != ')') {
                            stack.push(String.valueOf(operands.pop())); // pushing the middle of "( )"
                            operands.pop(); //pops the left parenthesis
                        }else{
                            throw new InvalidNotationFormatException();
                        }
                        hasOpen.remove(0); //since an arraylist of all true, just remove first element
                    }else if(c == ')'){
                        throw new InvalidNotationFormatException(); //closing parenthesis but no opening
                    } else {
                        operands.push(c);
                    }
                }else{
                    stack.push(String.valueOf(c)); //push if it's a digit
                }
            }
            return stack.toString();
        } catch (StackOverflowException | StackUnderflowException e) {
            throw new InvalidNotationFormatException();
        }
    }
}
