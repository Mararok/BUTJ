/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.tests;

import com.gmail.mararok.BUTJ.TestsRunner;
import com.gmail.mararok.BUTJ.ReportOutput.ConsoleReportOutput;


public class Tests {
	public static void main(String[] args) {
		TestsRunner runner = new TestsRunner("BUTJ TESTS",Tests.class.getPackage());
		runner.addReportOutput(new ConsoleReportOutput());
		runner.run();
	}
}
