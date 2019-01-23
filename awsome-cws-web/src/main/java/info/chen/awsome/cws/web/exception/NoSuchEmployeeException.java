package info.chen.awsome.cws.web.exception;

public class NoSuchEmployeeException extends RuntimeException {

	private static final long serialVersionUID = 2890583695990922999L;

	public NoSuchEmployeeException() {
		super();
	}

	public NoSuchEmployeeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchEmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchEmployeeException(String message) {
		super(message);
	}

	public NoSuchEmployeeException(Throwable cause) {
		super(cause);
	}

}
