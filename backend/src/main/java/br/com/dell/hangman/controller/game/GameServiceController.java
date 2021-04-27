package br.com.dell.hangman.controller.game;



import org.springframework.http.ResponseEntity;

import br.com.dell.hangman.controller.entity.HintRequest;
import br.com.dell.hangman.controller.entity.ResponseObject;
import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Hint;

public interface GameServiceController {
	ResponseEntity<ResponseObject<Game>> createGame(String dificulte);
	ResponseEntity<ResponseObject<Hint>> sendHint(HintRequest hintRequest); 
}
