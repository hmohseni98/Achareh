package customException;

public class AccountNotActive extends Exception{
    public AccountNotActive() {
        super("your account not active");
    }
}
