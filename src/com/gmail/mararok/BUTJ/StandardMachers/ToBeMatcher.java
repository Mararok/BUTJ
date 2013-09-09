/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.StandardMachers;

import com.gmail.mararok.BUTJ.Matcher;

public class ToBeMatcher extends Matcher {

	@Override
	public boolean match(Object current, Object expected) {
		return current.equals(expected);
	}

	@Override
	public String getJoint() {
		return "to be";
	}

}
