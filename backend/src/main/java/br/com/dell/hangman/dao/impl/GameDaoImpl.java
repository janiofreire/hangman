package br.com.dell.hangman.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dell.hangman.dao.GameDao;
import br.com.dell.hangman.entity.Game;

@Component
public class GameDaoImpl implements GameDao {

	private List<Game> listGames;
	private static int id=1;
	
	@Autowired
	public GameDaoImpl(List<Game> listGames) {
		this.listGames = listGames;
	}

	public List<Game> listAll() {
		return listGames;
	}

	public void insert(Game game) {
		game.setId(id++);
		listGames.add(game);
	}

	@Override
	public Game returnGameById(Integer gameId) {
		return listGames.stream().filter(g->g.getId().equals(gameId)).findFirst().get();
	}

}
