package br.com.dell.hangman.service;

import br.com.dell.hangman.entity.Word;
import br.com.dell.hangman.service.exceptions.WordNotFoundException;

public interface WordService {

	Integer getMaxWordId();

	Word returnWordById(Integer wordId)throws WordNotFoundException,NullPointerException;

	Word returnFirtWordLowerEquals(Integer id)throws WordNotFoundException,NullPointerException;

}
