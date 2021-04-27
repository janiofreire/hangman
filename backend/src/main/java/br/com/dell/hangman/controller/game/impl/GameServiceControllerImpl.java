package br.com.dell.hangman.controller.game.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dell.hangman.controller.entity.HintRequest;
import br.com.dell.hangman.controller.entity.ResponseObject;
import br.com.dell.hangman.controller.game.GameServiceController;
import br.com.dell.hangman.entity.Dificulte;
import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;
import br.com.dell.hangman.service.GameService;

@RestController
@RequestMapping("/game/")
public class GameServiceControllerImpl implements GameServiceController {

	private GameService gameService; 
	
	@Autowired
	public GameServiceControllerImpl(GameService gameService) {
		this.gameService = gameService;
	}

	@RequestMapping(path = "/createGame/{dificulte}", method = RequestMethod.POST)
	@Override
	public ResponseEntity<ResponseObject<Game>> createGame(@PathVariable("dificulte") String dificulte) {
		Game game = null;
		ResponseObject<Game> response = new ResponseObject<>();
		
		try {
			game = gameService.createGame(Dificulte.valueOf(dificulte));
			response.setListObjects(Arrays.asList(game));
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return new ResponseEntity<ResponseObject<Game>>(response, HttpStatus.BAD_REQUEST);
		} 
		return new ResponseEntity<ResponseObject<Game>>(response, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/sendHint", method = RequestMethod.POST)
	@Override
	public ResponseEntity<ResponseObject<Hint>>  sendHint(@RequestBody HintRequest hintRequest) {
		Hint hintLocal = null;
		ResponseObject<Hint> response = new ResponseObject<>();
		
		try {
			 hintLocal = gameService.sendHint(hintRequest.getGameId(), hintRequest.getLetter());
			 response.setListObjects(Arrays.asList(hintLocal));
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return new ResponseEntity<ResponseObject<Hint>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseObject<Hint>>(response, HttpStatus.ACCEPTED);
	}

}
