package br.com.dell.hangman.controller.mainpage.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.dell.hangman.controller.entity.MainPage;
import br.com.dell.hangman.controller.entity.ResponseObject;
import br.com.dell.hangman.controller.mainpage.MainPageController;
import br.com.dell.hangman.entity.Dificulte;
import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.service.GameService;

@RestController
@RequestMapping("/mainPage/")
public class MainPageControllerImpl implements MainPageController {
	private GameService gameService;

	@Autowired
	public MainPageControllerImpl(GameService gameService) {
		this.gameService = gameService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public ResponseObject<MainPage> getInitData() {
		List<Game> listGames = gameService.listAll();
		MainPage mainPage = new MainPage();
		mainPage.setListGames(listGames);
		mainPage.setDificultes(Arrays.asList(Dificulte.values()));
		ResponseObject<MainPage> responseObject = new ResponseObject<>();
		responseObject.setListObjects(Arrays.asList(mainPage));
		
		return responseObject;
	}

}
