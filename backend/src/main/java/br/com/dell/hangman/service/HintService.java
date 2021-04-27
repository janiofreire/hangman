package br.com.dell.hangman.service;

import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;
import br.com.dell.hangman.entity.HintResult;
import br.com.dell.hangman.service.exceptions.EmptyHintException;

public interface HintService {

	Hint addHint(String hint, Game game, HintResult hintResult) throws NullPointerException, EmptyHintException;


}
