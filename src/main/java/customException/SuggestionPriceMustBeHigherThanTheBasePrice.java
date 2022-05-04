package customException;

public class SuggestionPriceMustBeHigherThanTheBasePrice extends Exception {
    public SuggestionPriceMustBeHigherThanTheBasePrice() {
        super("suggestion price must be higher than the base price");
    }
}
