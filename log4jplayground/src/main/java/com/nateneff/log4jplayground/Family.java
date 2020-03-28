package com.nateneff.log4jplayground;

import org.apache.log4j.Logger;

public class Family {
	private static final Logger logger = Logger.getLogger(Family.class);


	public static void main(String[] args) {
	    Barney barney = new Barney();
	    Fred fred = new Fred();
		System.out.println("Starting.");
		Family family = new Family();
		family.logSomeStuff();
		barney.logSomeStuff();
		fred.logSomeStuff();
		System.out.println("Finished.");

    }
	
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
