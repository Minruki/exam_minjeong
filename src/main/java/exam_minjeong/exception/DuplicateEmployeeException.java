package exam_minjeong.exception;

@SuppressWarnings("serial")
public class DuplicateEmployeeException extends RuntimeException {

	public DuplicateEmployeeException(String message) {
		super(message);
	}

}
