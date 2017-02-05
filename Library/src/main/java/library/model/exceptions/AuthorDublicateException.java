/**
 * 
 */
package library.model.exceptions;

public class AuthorDublicateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304652430029611118L;

	/**
	 * 
	 */
	public AuthorDublicateException() {
		super();
	}

	/**
	 * @param message
	 */
	public AuthorDublicateException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AuthorDublicateException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AuthorDublicateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AuthorDublicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
