package br.com.dell.hangman.entity;

public enum Dificulte {
	HARD(1,"Hard"),NORMAL(2,"Normal"),EASY(3,"Easy");
	private String label;
	private Integer code;
	
	private Dificulte(Integer code,String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public Integer getCode() {
		return code;
	}

	
	
	
}
