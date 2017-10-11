package by.andruhovich.task.exception;

public class StringFormatException extends Exception {
    public StringFormatException(String message) {
        super(message);
    }

    public StringFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringFormatException(Throwable cause) {
        super(cause);
    }

    public StringFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
