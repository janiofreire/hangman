package br.com.dell.hangman.entity;

import java.util.Set;

public class HintResult {
	private Set<Integer> positions;
	private HintTypeResult hintTypeResult;
	private Result result;
	
	public Set<Integer> getPositions() {
		return positions;
	}
	public void setPositions(Set<Integer> positions) {
		this.positions = positions;
	}
	public HintTypeResult getHintTypeResult() {
		return hintTypeResult;
	}
	public void setHintTypeResult(HintTypeResult hintTypeResult) {
		this.hintTypeResult = hintTypeResult;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
}
