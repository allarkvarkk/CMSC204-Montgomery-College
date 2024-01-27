import java.util.ArrayList;


public class PasswordCheckerUtility {




public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
    if(!password.equals(passwordConfirm)){
        throw new UnmatchedException();
    }
}
public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
    return password.equals(passwordConfirm);
}
public static boolean isValidLength(String password) throws LengthException{
    if(password.length() >= 6){
        return true;
    }else{
        throw new LengthException();
    }
}

public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
    if(!password.equals(password.toLowerCase())){
        return true;
    }else{
        throw new NoUpperAlphaException();
    }
}
public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
    if(!password.equals(password.toUpperCase())){
        return true;
    }else{
        throw new NoLowerAlphaException();
    }
}
public static boolean hasDigital(String password) throws NoDigitException{
   for(int i = 0; i < password.length(); i ++){
       if(Character.isDigit(password.charAt(i))){
           return true;
       }
   }
   throw new NoDigitException();
}
public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
    for(int i = 0; i < password.length(); i ++){
       if(!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i))){
           return true;
       }
    }
    throw new NoSpecialCharacterException();
}
public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
    short count = 1;
    for (int i = 1; i < password.length(); i++) {
        if (password.charAt(i) == password.charAt(i - 1)) {
            ++count;
            if (count >=3) {
                throw new InvalidSequenceException();
            }
        } else {
            count = 1;
        }
    }
    return false;
}
public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
    if(!isValidLength(password)){
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
    return true;
}
public static boolean hasBetweenSixAndNineChars(String password){
   return password.length() >= 6 && password.length() <= 9;
}
public static boolean isWeakPassword(String password) throws WeakPasswordException{
    try {
        if (!isValidPassword(password) || hasBetweenSixAndNineChars(password)) {
            throw new WeakPasswordException();
        }
    }catch(Exception e){
        throw new WeakPasswordException();
    }
    return false;
}
public static ArrayList<String> getInvalidPasswords(ArrayList<String> password){
    ArrayList<String> temp = new ArrayList<String>();
    for(String s : password){
        try{
            isValidPassword(s);
        }catch(Exception e) {
            temp.add(s + " " + e.getMessage());
        }
    }
    return temp;
}
}
