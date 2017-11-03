package by.andruhovich.task.exception;

public class IllegalDataQuantityTechnicalException extends Exception{
    private int number;

    public IllegalDataQuantityTechnicalException(String message, int number) {
        super(message);
        this.number = number;
    }

    public IllegalDataQuantityTechnicalException(String message, Throwable cause, int number) {
        super(message, cause);
        this.number = number;
    }

    public IllegalDataQuantityTechnicalException(Throwable cause, int number) {
        super(cause);
        this.number = number;
    }

    public IllegalDataQuantityTechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int number) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.number = number;
    }
}
