/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import java.util.List;

public interface TestResults extends Results {
	public String getDescription();
	public List<UnexpectedResult> getUnexpectedResults();
}
