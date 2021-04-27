package br.com.dell.hangman.dao.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dell.hangman.dao.WordDao;
import br.com.dell.hangman.entity.Word;

@Component
public class WordDaoImpl implements WordDao {
	private List<Word> listWord;
	private Comparator<? super Word> maxIdComparator =new Comparator<Word>() {
		@Override
		public int compare(Word o1, Word o2) {
			return o1.getId().compareTo(o2.getId());
		}
	};

	@Autowired
	public WordDaoImpl(List<Word> listWord) {
		this.listWord = listWord;
	}

	public Integer getMaxWordId() {
		return (Integer)listWord.stream().max(maxIdComparator).map(w->w.getId()).get();
	}

	public Word returnWordById(Integer gameId) {
		return listWord.stream().filter(w->w.getId().equals(gameId)).findFirst().get();
	}

	public Word returnFirtWordLowerEquals(Integer id) {
		return listWord.stream().filter(w->w.getId().intValue()<=id.intValue())
				.sorted((w1,w2)->w1.getId().compareTo(w2.getId())*-1)
				.findFirst()
				.get();
	}

}
