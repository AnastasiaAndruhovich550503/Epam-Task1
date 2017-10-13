package by.andruhovich.task.exception;

public class DataIsEmptyTechnicalException extends Exception {
    public DataIsEmptyTechnicalException(String message) {
        super(message);
    }

    public DataIsEmptyTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIsEmptyTechnicalException(Throwable cause) {
        super(cause);
    }

    public DataIsEmptyTechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
