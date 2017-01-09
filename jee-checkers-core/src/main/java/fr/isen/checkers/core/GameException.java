package src.main.java.fr.isen.checkers.core;

/**
 * Created by Quentin on 09/01/2017.
 */
public class GameException extends RuntimeException {
    private final String message;

    public GameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}