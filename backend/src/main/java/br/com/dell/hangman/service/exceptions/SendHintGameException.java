package br.com.dell.hangman.service.exceptions;

public class SendHintGameException extends Exception {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SendHintGameException(WordNotFoundException e) {
		super(e);
	}

}
