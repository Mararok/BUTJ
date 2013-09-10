/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.tests;

import com.gmail.mararok.BUTJ.TestsRunner;
import com.gmail.mararok.BUTJ.Helpers.MockObject;
import com.gmail.mararok.BUTJ.Helpers.MockObjectBuilder;
import com.gmail.mararok.BUTJ.ReportOutput.ConsoleReportOutput;


public class Tests {
	public static void main(String[] args) {
		TestsRunner runner = new TestsRunner("BUTJ TESTS");
		runner.addReportOutput(new ConsoleReportOutput());
		runner.addCase(new SimpleTestCase());
		//runner.run();
		MockObjectBuilder builder = new MockObjectBuilder();
		MockObject object = builder.from(Tests.class);
		Tests t = (Tests)object.build();
		t.test(1, 2);
	}
	
	public void test(int elo1, int elo2) {
		
	}

}
