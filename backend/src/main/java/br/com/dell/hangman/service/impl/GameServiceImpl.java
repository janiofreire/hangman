package br.com.dell.hangman.service.impl;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dell.hangman.dao.GameDao;
import br.com.dell.hangman.entity.Dificulte;
import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;
import br.com.dell.hangman.entity.HintResult;
import br.com.dell.hangman.entity.HintTypeResult;
import br.com.dell.hangman.entity.Result;
import br.com.dell.hangman.entity.Word;
import br.com.dell.hangman.service.GameService;
import br.com.dell.hangman.service.HintService;
import br.com.dell.hangman.service.WordService;
import br.com.dell.hangman.service.exceptions.EmptyHintException;
import br.com.dell.hangman.service.exceptions.GameNotExisteException;
import br.com.dell.hangman.service.exceptions.GameServiceCreatGameException;
import br.com.dell.hangman.service.exceptions.HintGameFinishedException;
import br.com.dell.hangman.service.exceptions.SendHintGameException;
import br.com.dell.hangman.service.exceptions.WordNotFoundException;
import br.com.dell.hangman.util.GameUtil;
import br.com.dell.hangman.util.WordUtil;

@Service
public class GameServiceImpl implements GameService {

	private GameDao gameServiceDao;
	private WordService wordService;
	private HintService hintService;
	private static final String NULL_POINT_MSG = "The parameter must be not null";
	private static final String NULL_POINT_PARAMETER_MSG = "The parameter %s must be not null";
	
	@Autowired
	public GameServiceImpl(GameDao gameServiceDao, WordService wordService,HintService hintService) {
		this.gameServiceDao = gameServiceDao;
		this.wordService = wordService;
		this.hintService = hintService;
	}

	public List<Game> listAll() {
		return gameServiceDao.listAll();
	}

	private boolean isGameFinished(Game game) {
		return game.getResult()!=null;
	}	
	
	public Game createGame(Dificulte dificulte) throws GameServiceCreatGameException,NullPointerException { 
		try {
			
			if(dificulte==null) {
				throw new NullPointerException(NULL_POINT_MSG);
			}
			
			Integer maxWordId = wordService.getMaxWordId();
			Random random = new Random();
			int id = random.nextInt(maxWordId);
			Word word = wordService.returnFirtWordLowerEquals(id);
			Word copyWord = new Word(word.getId(),word.getLabel(),word.getLength());
			Game game = new Game();
			game.setWord(copyWord);
			game.setDificulte(dificulte);
			game.setMaxGuesses(creatMaxGuesses(dificulte,word));
			gameServiceDao.insert(game);
			copyWord.setLabel(null);
			return game;
			
		}catch (WordNotFoundException e) {
			throw new GameServiceCreatGameException(e);
		}
		
	}

	private Integer creatMaxGuesses(Dificulte dificulte, Word word) {
		int quantUniqueLetter = WordUtil.returnQuantUniqueLetter(word.getLabel());
		switch (dificulte) {
			case HARD:{
				return quantUniqueLetter;
			}
			case EASY:{
				return quantUniqueLetter+10;
			}
			default:
				return quantUniqueLetter+5;
		}
		
	}

	public Hint sendHint(Integer gameId, String hint) throws EmptyHintException,NullPointerException, GameNotExisteException
	, HintGameFinishedException, SendHintGameException {
		try {
			validateParams(gameId,hint);
			
			Game game = returnGameById(gameId);
			validateIfGameisOpen(game);
			Word word = wordService.returnWordById(game.getWord().getId());
			Set<Integer> positions = WordUtil.returnPositions(word.getLabel(),hint);
			HintResult hintResult = new HintResult();
			
			if(positions==null || positions.isEmpty()) {
				hintResult.setHintTypeResult(HintTypeResult.WRONG);
			}else {
				hintResult.setHintTypeResult(HintTypeResult.RIGHT);
			}
			
			hintResult.setPositions(positions);
			
			Hint localHint = hintService.addHint(hint,game,hintResult);  
			
			Result result = extractResulGame(game,word);
			
			if(result!=null) {
				hintResult.setResult(result);
			}
			
			
			return localHint;
		}catch (WordNotFoundException e) {
			throw new SendHintGameException(e);
		}
	}

	private Result extractResulGame(Game game, Word word) throws NullPointerException{
		Result result=null;
		
		if(isEndGame(game) || GameUtil.isResultWin(game,word)) {
			result = extractResult(game,word);
			game.setResult(result);
		}
		
		return result;
	}

	private Result extractResult(Game game, Word word) throws NullPointerException {
		if(GameUtil.isResultWin(game,word)) {
			return Result.WIN;
		}else {
			return Result.FAIL;
		}
	}

	private boolean isEndGame(Game game) {
		return game.getHints()!=null && game.getHints().size()>=game.getMaxGuesses().intValue();
	}

	private void validateIfGameisOpen(Game game)throws HintGameFinishedException {
		if(isGameFinished(game)) {
			throw new HintGameFinishedException();
		}
	}

	public Game returnGameById(Integer gameId)throws GameNotExisteException{
		Game game = null;
		
		game = gameServiceDao.returnGameById(gameId);
		
		if(game==null || game.getId()==null) {
			throw new GameNotExisteException();
		}
		
		return game;
	}

	private void validateParams(Integer gameId, String hint)throws NullPointerException,EmptyHintException {
		if(gameId==null) {
			throw new NullPointerException(String.format(NULL_POINT_PARAMETER_MSG, "gameId"));
		}
		if(hint==null) {
			throw new NullPointerException(String.format(NULL_POINT_PARAMETER_MSG, "hint"));
		}
		if(hint.trim().isEmpty()) {
			throw new EmptyHintException("The parameter hint must be not empty");
		}
	}


}
