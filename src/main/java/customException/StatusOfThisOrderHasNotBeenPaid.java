package customException;

public class StatusOfThisOrderHasNotBeenPaid extends Exception{
    public StatusOfThisOrderHasNotBeenPaid() {
        super("Status of this order has not been paid");
    }
}
