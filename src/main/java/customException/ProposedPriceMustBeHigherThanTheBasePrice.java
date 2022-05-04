package customException;

public class ProposedPriceMustBeHigherThanTheBasePrice extends Exception{
    public ProposedPriceMustBeHigherThanTheBasePrice() {
        super("proposed price must be higher than the base price");
    }
}
