package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		IMS ims = new IMS();
		ims.imsSystem();
		LOGGER.info("SO LONG!");
	}

}




//order total currently broken, aim to fix during JUnit testing

//On to testing. Some of it is there to build of from, but orderController might be a challenge, prepare accordingly
//The DAOs are also weird because of how they access database stuff