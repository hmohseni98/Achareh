package customException;

public class SuggestionPriceMustBeHigherThanTheBasePrice extends RuntimeException {
    public SuggestionPriceMustBeHigherThanTheBasePrice() {
        super("suggestion price must be higher than the base price");
    }
}
