package br.com.dell.hangman.entity;

public class Word {
	private Integer id;
	private String label;
	private Integer length;
	
	public Word(Integer id, String label,Integer length) {
		this.id = id;
		this.label = label;
		this.length = length;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	
}
