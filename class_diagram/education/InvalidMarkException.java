package education;

public class InvalidMarkException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidMarkException(String message) {
        super(message) ;
    }
}
