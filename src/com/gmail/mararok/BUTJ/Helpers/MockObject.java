/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Helpers;

public interface MockObject<T> {
	MockObject<T> withName(String objectName);
	
	MockObject<T> when(String methodName);
	MockObject<T> get(Object... args);
	MockObject<T> thenGive(Object returnValue);
	MockObject<T> thenThrow(Exception throwsException);
	MockObject<T> and();
	T close();
}
