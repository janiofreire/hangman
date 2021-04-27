package br.com.dell.hangman.entity;

public class Hint {
	private Integer id;
	private String letter;
	private HintResult hintResult;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public HintResult getHintResult() {
		return hintResult;
	}
	public void setHintResult(HintResult hintResults) {
		this.hintResult = hintResults;
	}
}
