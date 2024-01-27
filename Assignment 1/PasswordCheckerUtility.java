



import java.util.ArrayList;
public class PasswordCheckerUtility {

public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
    if(!password.equals(passwordConfirm)){ //if not equal
        throw new UnmatchedException();
    }
}
public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
    return password.equals(passwordConfirm); //return boolean or if equal or not
}
public static boolean isValidLength(String password) throws LengthException{
    if(password.length() >= 6){
        return true;
    }else{
        throw new LengthException();
    }
}

public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
    if(!password.equals(password.toLowerCase())){ //if password is equal to password in all lowercase it means there were no uppercase
        return true;
    }else{
        throw new NoUpperAlphaException();
    }
}
public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
    if(!password.equals(password.toUpperCase())){ //if password is equal to password in all uppercase it means there were no lowercase
        return true;
    }else{
        throw new NoLowerAlphaException();
    }
}
public static boolean hasDigital(String password) throws NoDigitException{
   for(int i = 0; i < password.length(); i ++){
       if(Character.isDigit(password.charAt(i))){
           return true; //return true if a char is a digit
       }
   }
   throw new NoDigitException();
}
public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
    for(int i = 0; i < password.length(); i ++){
       if(!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i))){
           return true; //return true if a char is not a digit or a letter meaning special character
       }
    }
    throw new NoSpecialCharacterException();
}
public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
    short count = 1;
    for (int i = 1; i < password.length(); i++) { //start at 1 because we compare to i - 1
        if (password.charAt(i) == password.charAt(i - 1)) { //compare previous to current char
            ++count; //increase by one if matching
            if (count >=3) {
                throw new InvalidSequenceException();
            }
        } else {
            count = 1; //if not matching chars reset count to 1
        }
    }
    return false; //return false if exception never thrown
    //Why is this function called "NoSameCharInSequence" and is supposed to return false when there is "no same chars in sequence" instead of true
}
public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
    if(!isValidLength(password)){ //the order of the exceptions is because the JavaDoc
        throw new LengthException();
    }
    if(!hasUpperAlpha(password)){
        throw new NoUpperAlphaException();
    }
    if(!hasLowerAlpha(password)){
        throw new NoLowerAlphaException();
    }
    if(!hasDigital(password)){
        throw new NoDigitException();
    }
    if(!hasSpecialChar(password)){
        throw new NoSpecialCharacterException();
    }
    if(NoSameCharInSequence(password)){
        throw new InvalidSequenceException();
    }
    return true; //return true if no exception thrown
}
public static boolean hasBetweenSixAndNineChars(String password){
   return password.length() >= 6 && password.length() <= 9;
}
public static boolean isWeakPassword(String password) throws WeakPasswordException{
    try {
        if (!isValidPassword(password) || hasBetweenSixAndNineChars(password)) {
            throw new WeakPasswordException(); //if it's invalid of a length of 6-9 throw the error
        }
    }catch(Exception e){
        throw new WeakPasswordException(); //catch the exceptions from isValidPassword and throw a different exception
    }
    return false;
}
public static ArrayList<String> getInvalidPasswords(ArrayList<String> password){
    ArrayList<String> temp = new ArrayList<String>();
    for(String s : password){
        try{
            isValidPassword(s);
        }catch(Exception e) {
            temp.add(s + " " + e.getMessage()); //if it's not a valid password write it with the message
        }
    }
    return temp; //return the arraylist
}
}
