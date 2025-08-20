package in.ineuron.exception;

/*
 *  Our custom exception
 */
public class StudentRecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentRecordNotFoundException(String message) {
		super(message);
	}
}
