package info.chen.awsome.cws.persist.exception;

public class EmployeeException extends Exception{

	private static final long serialVersionUID = 6243977981523563507L;

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
