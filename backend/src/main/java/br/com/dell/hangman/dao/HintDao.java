package br.com.dell.hangman.dao;

import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;
import br.com.dell.hangman.entity.HintResult;

public interface HintDao {

	Hint add(String hint, Game game, HintResult hintResult);

}
