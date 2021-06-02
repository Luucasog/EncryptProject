public class NotFoundException extends Exception {

    public NotFoundException() {
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}