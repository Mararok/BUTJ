/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

public interface TestEnviroment {
	
	public void describe(String description);
	public TestEnviroment expect(Object current);
	
	public TestEnviroment toBe(Object expected);
	public TestEnviroment toBeNull();
	
	public TestEnviroment toBeTrue();
	public TestEnviroment toBeFalse();
	
	public TestEnviroment toBeEqual(Comparable<?> expected);
	
	public TestEnviroment not();
	public TestEnviroment or();
	public TestEnviroment and();
}
