package br.com.dell.hangman.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.dell.hangman.dao.HintDao;
import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;
import br.com.dell.hangman.entity.HintResult;

@Component
public class HintDaoImpl implements HintDao {

	@Override
	public Hint add(String hint, Game game,HintResult hintResult) {
		List<Hint> hints = game.getHints();
		if(hints == null) {
			hints = new ArrayList<>();
			game.setHints(hints);
		}
		Hint hintObject = new Hint();
		hintObject.setLetter(hint);
		hintObject.setHintResult(hintResult);
		hints.add(hintObject);
		return hintObject;
		
	}

}
