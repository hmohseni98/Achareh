package customException;

public class DoNotHaveAccessToThisOrder extends Exception{
    public DoNotHaveAccessToThisOrder() {
        super("do not have access to this order");
    }
}
