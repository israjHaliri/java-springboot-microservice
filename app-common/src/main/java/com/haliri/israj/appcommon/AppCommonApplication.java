package com.haliri.israj.appcommon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppCommonApplication {

	public static Logger getLogger(Object o) {
		return LoggerFactory.getLogger(o.getClass());
	}
}
