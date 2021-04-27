package br.com.dell.hangman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dell.hangman.dao.HintDao;
import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;
import br.com.dell.hangman.entity.HintResult;
import br.com.dell.hangman.service.HintService;
import br.com.dell.hangman.service.exceptions.EmptyHintException;

@Service
public class HintServiceImpl implements HintService {
	private HintDao hintDao; 
	private static final String NULL_POINT_PARAMETER_MSG = "The parameter %s must be not null";
	
	@Autowired
	public HintServiceImpl(HintDao hintDao) {
		this.hintDao = hintDao;
	}

	@Override
	public Hint addHint(String hint, Game game,HintResult hintResult) throws NullPointerException,EmptyHintException {
		verifyParameters(hint,game);
		return hintDao.add(hint,game, hintResult);
	}

	private void verifyParameters(String hint, Game game)throws NullPointerException,EmptyHintException {
		if(hint ==null) {
			throw new NullPointerException(String.format(NULL_POINT_PARAMETER_MSG, "hint"));
		}
		if(game==null) {
			throw new NullPointerException(String.format(NULL_POINT_PARAMETER_MSG, "game"));
		}
		if(hint.trim().isEmpty()) {
			throw new EmptyHintException();
		}
	}

}
