package br.com.dell.hangman.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.dell.hangman.entity.Game;
import br.com.dell.hangman.entity.Word;

public class GameUtil {

	public static boolean isResultWin(Game game, Word word) {
		Set<String> hintsString = getStringHints(game);
		Set<String> letters = getLetter(word.getLabel());
		
		return letters.stream().filter(l-> hintsString.contains(l))
				.count()==letters.size();
	}

	private static Set<String> getLetter(String label) {
		return Arrays.asList(label.toUpperCase().split("")).stream()
				.collect(Collectors.toSet());
	}

	private static Set<String> getStringHints(Game game) {
		return game.getHints().stream().map(h-> h.getLetter().toUpperCase())
				.collect(Collectors.toSet());
	}
	
}
