package com.nateneff.log4jplayground;

import org.apache.log4j.Logger;

public class Barney {
	private static final Logger logger = Logger.getLogger(Barney.class);

	public void logSomeStuff() {
		String className = this.getClass().getName();

		logger.trace("Trace from: " + className);
		logger.debug("Debug from: " + className);
		logger.info("Info from: " + className);
		logger.warn("Warn from: " + className);
		logger.error("Error from: " + className);
		logger.fatal("Fatal from: " + className);
	}

}
