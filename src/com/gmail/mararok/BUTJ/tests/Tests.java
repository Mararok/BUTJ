/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.tests;

import com.gmail.mararok.BUTJ.TestsRunner;

public class Tests {
	public static void main(String[] args) {
		TestsRunner runner = new TestsRunner("BUTJ TESTS");
		runner.addReportOutput(new ConsoleReportOutput());
		runner.run();
	}

}
