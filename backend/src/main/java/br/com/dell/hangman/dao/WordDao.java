package br.com.dell.hangman.dao;

import br.com.dell.hangman.entity.Word;

public interface WordDao {

	Integer getMaxWordId();

	Word returnWordById(Integer gameId);

	Word returnFirtWordLowerEquals(Integer id);

}
