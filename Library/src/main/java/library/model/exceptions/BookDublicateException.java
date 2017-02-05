/**
 * 
 */
package library.model.exceptions;

public class BookDublicateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304652430029611118L;

	/**
	 * 
	 */
	public BookDublicateException() {
		super();
	}

	/**
	 * @param message
	 */
	public BookDublicateException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BookDublicateException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BookDublicateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BookDublicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
