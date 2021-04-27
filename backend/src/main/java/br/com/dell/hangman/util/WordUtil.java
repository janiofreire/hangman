package br.com.dell.hangman.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordUtil {

	public static int returnQuantUniqueLetter(String label) {
		if(label!=null && !label.isEmpty()) {
			Pattern pattern = Pattern.compile("(\\p{IsAlphabetic})");
			Matcher matcher = pattern.matcher(label);
			Set<String> letter = new HashSet<String>();
			while(matcher.find()) {
				letter.add(matcher.group(1));
			}
			return letter.size();
		}
		return 0;
	}

	public static Set<Integer> returnPositions(String label, String hint) {
		Set<Integer> positions = new HashSet<Integer>();
		Pattern pattern = Pattern.compile(hint);
		Matcher matcher = pattern.matcher(label);

		while(matcher.find()) {
			positions.add(matcher.start());
		}
		
		return positions;
	}
	
}
