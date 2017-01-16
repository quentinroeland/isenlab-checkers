package fr.isen.checkers.core.exceptions;

/**
 * Created by maxim on 12/01/2017.
 */
public class BoardException extends IndexOutOfBoundsException{
    private String message;

    public BoardException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
