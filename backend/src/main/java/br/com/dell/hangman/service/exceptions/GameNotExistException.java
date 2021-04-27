package br.com.dell.hangman.service.exceptions;

public class GameNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ERRO_MSG_TEMPLATE = "No game was found for the id:";

	public GameNotExistException(Integer id) {
		super(String.format(ERRO_MSG_TEMPLATE, id));
	}
	
}
