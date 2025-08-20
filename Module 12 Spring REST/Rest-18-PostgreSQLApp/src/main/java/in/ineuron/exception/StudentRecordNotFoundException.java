package in.ineuron.exception;

public class StudentRecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentRecordNotFoundException(String message) {
		super(message);
	}
}
