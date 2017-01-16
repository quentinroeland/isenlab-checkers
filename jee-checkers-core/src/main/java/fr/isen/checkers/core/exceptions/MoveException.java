package fr.isen.checkers.core.exceptions;

/**
 * Created by Quentin on 15/01/2017.
 */
public class MoveException extends Exception{
    private String message;

    public MoveException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
