package info.chen.awsome.cws.web.exception;

public class NoSuchSalaryException extends RuntimeException {

	private static final long serialVersionUID = 6895158114131752178L;

	public NoSuchSalaryException() {
		super();
	}

	public NoSuchSalaryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchSalaryException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchSalaryException(String message) {
		super(message);
	}

	public NoSuchSalaryException(Throwable cause) {
		super(cause);
	}

}
