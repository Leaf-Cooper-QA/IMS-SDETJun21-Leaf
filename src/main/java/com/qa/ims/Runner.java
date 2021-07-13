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


//All the controllers are done but there's a small issue within OrderController. It's operational but look at it if time allows.
//Now it's just the DAO which shouldn't have as much trouble other than figuring out what the set up is in the example

//If you're still short of 80% then there's minor enums around the place that make up some extra numbers