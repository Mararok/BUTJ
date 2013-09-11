/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.Test.Reporter;
import com.gmail.mararok.BUTJ.Test.TestElementImpl;

public class ResultsImpl {
	private TestElementImpl element;
	
	private long startTime;
	private long executeTime;
	
	public ResultsImpl(TestElementImpl element) {
		this.element = element;
	}

	public String getName() {
		return getElement().getName();
	}

	public String getFullName() {
		return getElement().getFullName();
	}
	
	public long getExecuteTime() {
		return executeTime;
	}
	
	protected void onStart() {
		startTime = System.currentTimeMillis();
	}
	
	protected  void onEnd() {
		executeTime = System.currentTimeMillis()-startTime;
	}
	
	protected Reporter getReporter() {
		return getElement().getReporter();
	}
	
	private TestElementImpl getElement() {
		return element;
	}
}
