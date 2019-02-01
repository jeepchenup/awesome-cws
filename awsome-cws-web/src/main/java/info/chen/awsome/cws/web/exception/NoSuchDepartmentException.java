package info.chen.awsome.cws.web.exception;

public class NoSuchDepartmentException extends RuntimeException {

	private static final long serialVersionUID = -406817549465015193L;

	public NoSuchDepartmentException() {
		super();
	}

	public NoSuchDepartmentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchDepartmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchDepartmentException(String message) {
		super(message);
	}

	public NoSuchDepartmentException(Throwable cause) {
		super(cause);
	}

}
