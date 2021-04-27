package br.com.dell.hangman.controller.mainpage;

import br.com.dell.hangman.controller.entity.MainPage;
import br.com.dell.hangman.controller.entity.ResponseObject;

public interface MainPageController {

	ResponseObject<MainPage> getInitData();
}
