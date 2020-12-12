package mail.ilyin_gk.avia.exception;

public class ServiseException extends RuntimeException {
    public ServiseException() {
        super();
    }

    public ServiseException(String message) {
        super(message);
    }

    public ServiseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiseException(Throwable cause) {
        super(cause);
    }

    protected ServiseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
