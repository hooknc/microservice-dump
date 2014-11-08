package name.hooknc.ncdump;

public class NcdumpException extends RuntimeException {

    public NcdumpException(String message) {
        super(message);
    }

    public NcdumpException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NcdumpException(Throwable throwable) {
        super(throwable);
    }
}
