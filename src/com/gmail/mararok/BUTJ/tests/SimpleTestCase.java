/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.tests;

import com.gmail.mararok.BUTJ.TEST;
import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.BUTJ.TestEnviroment;

public class SimpleTestCase extends TestCase {

	public SimpleTestCase() {
		super("Simple");
	}
	
	@TEST
	public void toBe(TestEnviroment it) {
		Integer obj1 = 1;
		Integer obj2 = obj1;
		it.expect(obj1).toBe(obj2);
		it.expect(obj2).not().toBe(null);
	}
	
	@TEST
	public void toBeNull(TestEnviroment it) {
		Object obj1 = null;
		Object obj2 = 1;
		
		it.expect(obj1).toBeNull();
		it.expect(obj2).not().toBeNull();
	}
	
	@TEST
	public void toBeFalse(TestEnviroment it) {
		Object obj1 = null;
		Object obj2 = 1;
		
		it.expect(false).toBeFalse();
		it.expect(obj1).toBeFalse();
		
		it.expect(true).not().toBeFalse();
		it.expect(obj2).not().toBeFalse();
	}
	
	@TEST
	public void toBeTrue(TestEnviroment it) {
		Object obj1 = 1;
		Object obj2 = null;
		
		it.expect(true).toBeTrue();
		it.expect(obj1).toBeTrue();
		
		it.expect(false).not().toBeTrue();
		it.expect(obj2).not().toBeTrue();
	}
	
}
