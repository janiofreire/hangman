package br.com.dell.hangman.service;

import java.util.List;

import br.com.dell.hangman.entity.Dificulte;
import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;
import br.com.dell.hangman.service.exceptions.EmptyHintException;
import br.com.dell.hangman.service.exceptions.GameNotExisteException;
import br.com.dell.hangman.service.exceptions.GameServiceCreatGameException;
import br.com.dell.hangman.service.exceptions.HintGameFinishedException;
import br.com.dell.hangman.service.exceptions.SendHintGameException;

public interface GameService {
	List<Game> listAll();
	Game createGame(Dificulte dificulte)throws GameServiceCreatGameException,NullPointerException;
	Hint sendHint(Integer game,String hint) throws EmptyHintException,NullPointerException, GameNotExisteException
	, HintGameFinishedException,SendHintGameException;
}
