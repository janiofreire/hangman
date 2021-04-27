package br.com.dell.hangman.dao;

import java.util.List;

import br.com.dell.hangman.entity.Game;

public interface GameDao {

	List<Game> listAll();

	void insert(Game game);

	Game returnGameById(Integer gameId);

}
