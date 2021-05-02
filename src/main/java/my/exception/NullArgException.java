package my.exception;

public class NullArgException extends RuntimeException{
    String message;
    public NullArgException(String s) {
        message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
