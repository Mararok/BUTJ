/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.tests;

import com.gmail.mararok.BUTJ.TEST;
import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.BUTJ.TestEnviroment;

public class MockObjectCase extends TestCase {
	
	public MockObjectCase() {
		super("MockObject");
	}

	@TEST
	public void mockBuild(TestEnviroment it) {
		SimpleClass obj = it.need().MockObject().from(SimpleClass.class).withName("mockBuild").
			when("method3").thenGive(1).
			when("method4").get(1,1.0).thenGive(2).
			close();
		
		it.expect(obj.method3()).toBeEqual(1);
		it.expect(obj.method4(1,1)).toBeEqual(2);
	}

}
