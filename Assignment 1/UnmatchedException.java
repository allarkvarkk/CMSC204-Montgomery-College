public class UnmatchedException extends Exception{
    //The Word document provided says the message should be "The passwords do not match" but the PasswordCheckerTestPublic does not have a "The"
    public UnmatchedException(){
        super("Passwords do not match");
    }
}
