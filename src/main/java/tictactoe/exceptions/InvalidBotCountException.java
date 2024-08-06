package tictactoe.exceptions;

public class InvalidBotCountException extends Exception {
    //It is directly extend from Exception, because it is checkedException
    public InvalidBotCountException(String message) {
        super(message);
    }
}
