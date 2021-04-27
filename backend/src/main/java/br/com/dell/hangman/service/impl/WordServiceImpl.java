package br.com.dell.hangman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dell.hangman.dao.WordDao;
import br.com.dell.hangman.entity.Word;
import br.com.dell.hangman.service.WordService;
import br.com.dell.hangman.service.exceptions.WordNotFoundException;

@Service
public class WordServiceImpl implements WordService {
	private WordDao wordDao;
	private static final String NULL_POINT_MSG = "The parameter must be not null";
	
	@Autowired
	public WordServiceImpl(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public Integer getMaxWordId() {
		return wordDao.getMaxWordId();
	}

	public Word returnWordById(Integer wordId) throws WordNotFoundException,NullPointerException {
		if(wordId==null) {
			throw new NullPointerException(NULL_POINT_MSG);
		}
		Word word = wordDao.returnWordById(wordId);
		
		if(word==null || word.getId()==null) {
			throw new WordNotFoundException();
		}
		
		return word;
	}

	public Word returnFirtWordLowerEquals(Integer id) throws WordNotFoundException,NullPointerException {
		if(id==null) {
			throw new NullPointerException(NULL_POINT_MSG);
		}
		
		Word word = wordDao.returnFirtWordLowerEquals(id);
		
		if(word==null || word.getId()==null) {
			throw new WordNotFoundException();
		}
		
		return word;
	}

}
