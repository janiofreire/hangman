package br.com.dell.hangman.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.dell.hangman.dao.WordDao;
import br.com.dell.hangman.service.WordService;
import br.com.dell.hangman.service.exceptions.GameServiceCreatGameException;
import br.com.dell.hangman.service.impl.WordServiceImpl;
import br.com.dell.hangman.test.DefaultRunnerAction;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class WordServiceTest {
	private WordService wordService;
	
	public void init() {
		wordService = new WordServiceImpl(Mockito.mock(WordDao.class));
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
	public void testNullReturnFirtWordLowerEquals() throws Exception{
		runTextNullValue(()->wordService.returnFirtWordLowerEquals(null));
	}
	
	@Test
	public void testNullReturnWordById() throws Exception{
		runTextNullValue(()->wordService.returnWordById(null));
	}
	
	
}
