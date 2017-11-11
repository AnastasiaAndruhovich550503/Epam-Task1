package by.andruhovich.task.exception;

public class IllegalDataQuantityTechnicalException extends Exception {
    public IllegalDataQuantityTechnicalException(String message) {
        super(message);
    }

    public IllegalDataQuantityTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalDataQuantityTechnicalException(Throwable cause) {
        super(cause);
    }

    public IllegalDataQuantityTechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
