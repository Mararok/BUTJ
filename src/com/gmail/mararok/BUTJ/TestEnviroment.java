/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import com.gmail.mararok.BUTJ.Helpers.NeedHelper;

public interface TestEnviroment {
	
	public void describe(String description);
	public NeedHelper need();
	public TestEnviroment expect(Object current);
	
	public TestEnviroment toBe(Object expected);
	public TestEnviroment toBeInstanceOf(Class<?> expected);
	public TestEnviroment toBeNull();
	
	public TestEnviroment toBeTrue();
	public TestEnviroment toBeFalse();
	
	public TestEnviroment toBeEqual(Object expected);
	
	public TestEnviroment not();
	public TestEnviroment or();
	public TestEnviroment and();
}
