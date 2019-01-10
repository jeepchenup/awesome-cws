package info.chen.awsome_cws_web.exception;

public class EmployeeException extends Exception {

	public EmployeeException() {
		super();
	}

	public EmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeException(String message) {
		super(message);
	}

	public EmployeeException(Throwable cause) {
		super(cause);
	}

}
