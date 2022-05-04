package customException;

public class ScoreOutOfRange extends Exception{
    public ScoreOutOfRange() {
        super("Score out of range");
    }
}
