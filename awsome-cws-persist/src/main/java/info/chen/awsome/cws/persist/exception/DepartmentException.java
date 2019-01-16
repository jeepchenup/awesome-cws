package info.chen.awsome.cws.persist.exception;

public class DepartmentException extends Exception {

	private static final long serialVersionUID = -1013884422366966945L;

	public DepartmentException() {
		super();
	}

	public DepartmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DepartmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentException(String message) {
		super(message);
	}

	public DepartmentException(Throwable cause) {
		super(cause);
	}

}
