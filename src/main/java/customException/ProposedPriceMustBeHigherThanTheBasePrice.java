package customException;

public class ProposedPriceMustBeHigherThanTheBasePrice extends RuntimeException{
    public ProposedPriceMustBeHigherThanTheBasePrice() {
        super("proposed price must be higher than the base price");
    }
}
