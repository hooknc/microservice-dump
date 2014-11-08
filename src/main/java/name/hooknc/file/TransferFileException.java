package name.hooknc.file;

public class TransferFileException extends RuntimeException {

    public TransferFileException(String message) {
        super(message);
    }

    public TransferFileException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public TransferFileException(Throwable throwable) {
        super(throwable);
    }
}
