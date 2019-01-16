package info.chen.awsome.cws.persist.exception;

public class SalaryException extends Exception{

	private static final long serialVersionUID = -9149066360134609854L;

	public SalaryException() {
		super();
	}

	public SalaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SalaryException(String message, Throwable cause) {
		super(message, cause);
	}

	public SalaryException(String message) {
		super(message);
	}

	public SalaryException(Throwable cause) {
		super(cause);
	}

}
