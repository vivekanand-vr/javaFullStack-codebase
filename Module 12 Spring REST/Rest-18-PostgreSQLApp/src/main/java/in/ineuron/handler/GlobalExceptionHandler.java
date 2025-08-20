package in.ineuron.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.StudentRecordNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentRecordNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundException(StudentRecordNotFoundException se) {

		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), se.getMessage(), "Record Not found"), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleOtherException(Exception se) {
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(LocalDateTime.now(), se.getMessage(), "internal server error"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
