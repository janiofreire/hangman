package br.com.dell.hangman.entity;

public enum Result {
	WIN(1,"Win"),FAIL(2,"Fail");
	private String label;
	private Integer code;
	
	private Result(Integer code,String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public Integer getCode() {
		return code;
	}
}
