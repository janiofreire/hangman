package br.com.dell.hangman.controller.entity;

import java.util.List;

public class ResponseObject<O> {
	private String message;
	private List<O> listObjects;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<O> getListObjects() {
		return listObjects;
	}
	public void setListObjects(List<O> listObjects) {
		this.listObjects = listObjects;
	}
	
	
}
