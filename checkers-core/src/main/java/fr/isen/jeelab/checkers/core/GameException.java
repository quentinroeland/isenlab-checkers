package fr.isen.jeelab.checkers.core;

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
