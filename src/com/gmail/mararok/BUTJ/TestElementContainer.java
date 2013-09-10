/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import java.util.LinkedList;
import java.util.List;

public abstract class TestElementContainer extends TestElementImpl {
	private List<TestElementImpl> elements;
	public TestElementContainer(String name) {
		super(name);
		elements = new LinkedList<TestElementImpl>();
	}
	
	void add(TestElementImpl element) {
		element.setParent(this);
		getList().add(element);
	}
	
	void remove(TestElementImpl element) {
		getList().remove(element);
	}
	
	List<TestElementImpl> getList() {
		return elements;
	}
}
