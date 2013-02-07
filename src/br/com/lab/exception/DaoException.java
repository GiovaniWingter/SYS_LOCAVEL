package br.com.lab.exception;

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable throwed) {
		super(throwed);
	}

	public DaoException(String message, Throwable throwed) {
		super(message, throwed);
	}

}