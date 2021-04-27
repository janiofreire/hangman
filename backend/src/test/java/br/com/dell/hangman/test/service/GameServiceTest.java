package br.com.dell.hangman.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.dell.hangman.dao.GameDao;
import br.com.dell.hangman.service.GameService;
import br.com.dell.hangman.service.WordService;
import br.com.dell.hangman.service.exceptions.GameServiceCreatGameException;
import br.com.dell.hangman.service.exceptions.EmptyHintException;
import br.com.dell.hangman.service.impl.GameServiceImpl;
import br.com.dell.hangman.test.DefaultRunnerAction;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class GameServiceTest {
	private GameService gameService;
	
	@Before
	public void initTest() {
		gameService = new GameServiceImpl(Mockito.mock(GameDao.class), Mockito.mock(WordService.class));
	}
	
	
	public void runTextNullValue(DefaultRunnerAction runner)throws Exception{
		try {
			runner.run();
			assert(false);  
		} catch (NullPointerException e) {
			assert(true);
		} catch (GameServiceCreatGameException e) {
			assert(false);
		}
	}
	
	@Test
	public void testNullParamOnCreateGame() throws Exception{
		runTextNullValue(()->gameService.createGame(null));
	}
	
	@Test
	public void testNullParamOnSendHintAllParams() throws Exception{
		runTextNullValue(()->gameService.sendHint(null, null));
	}
	
	@Test
	public void testNullParamOnSendHintFirstParams() throws Exception{
		runTextNullValue(()->gameService.sendHint(null, new String() ));
	}
	
	@Test
	public void testNullParamOnSendHintSecondParams() throws Exception{
		runTextNullValue(()->gameService.sendHint(new Integer(0), null ));
	}
	
	@Test
	public void testNullParamOnSendHintEmptyString() throws Exception{
		try {
			gameService.sendHint(new Integer(0), new String() );
			assert(false);  
		} catch (NullPointerException e) {
			assert(false);
		} catch (EmptyHintException e) {
			assert(true);
		}
	}
	
	
}
