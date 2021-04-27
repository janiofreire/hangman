package br.com.dell.hangman.entity;

import java.util.List;

public class Game {
	private Integer id;
	private Word word;
	private List<Hint> hints;
	private Integer maxGuesses;
	private Dificulte dificulte;
	private Result Result;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMaxGuesses() {
		return maxGuesses;
	}
	public void setMaxGuesses(Integer maxGuesses) {
		this.maxGuesses = maxGuesses;
	}
	public Dificulte getDificulte() {
		return dificulte;
	}
	public void setDificulte(Dificulte dificulte) {
		this.dificulte = dificulte;
	}
	public Result getResult() {
		return Result;
	}
	public void setResult(Result result) {
		Result = result;
	}
	public List<Hint> getHints() {
		return hints;
	}
	public void setHints(List<Hint> hints) {
		this.hints = hints;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	
}
