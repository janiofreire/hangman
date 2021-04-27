package br.com.dell.hangman.service.exceptions;

public class GameServiceCreatGameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameServiceCreatGameException(WordNotFoundException e) {
		super(e);
	}

}
