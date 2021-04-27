package br.com.dell.hangman.controller.entity;

import java.util.List;

import br.com.dell.hangman.entity.Dificulte;
import br.com.dell.hangman.entity.Game;

public class MainPage {
	private List<Game> listGames;
	private List<Dificulte> dificultes;

	public List<Dificulte> getDificultes() {
		return dificultes;
	}
	public void setDificultes(List<Dificulte> dificultes) {
		this.dificultes = dificultes;
	}
	public List<Game> getListGames() {
		return listGames;
	}
	public void setListGames(List<Game> listGames) {
		this.listGames = listGames;
	}
	
}
