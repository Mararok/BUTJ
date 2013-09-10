/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

public class UnexpectedResult {
	private String matchMessage;
	private String sourceName = "|EMPTY|";
	private int lineNumber;
	
	public UnexpectedResult(String matchMessage, StackTraceElement position) {
		this.matchMessage = matchMessage;
		if (position.getFileName() != null) {
			this.sourceName = position.getFileName().split("\\.")[0];
		}
		this.lineNumber = position.getLineNumber();
	}
	
	
	public String getMatchMessage() {
		return this.matchMessage;
	}
	
	public String getSourceName() {
		return this.sourceName;
	}
	
	public int getLineNumber() {
		return this.lineNumber;
	}
}
