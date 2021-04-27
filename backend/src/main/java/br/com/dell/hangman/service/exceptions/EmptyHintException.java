package br.com.dell.hangman.service.exceptions;

public class EmptyHintException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyHintException(WordNotFoundException e) {
		super(e);
	}

	public EmptyHintException(String string) {
		super(string);
	}

	public EmptyHintException() {
		super("The hint must not be empty");
	}

}
