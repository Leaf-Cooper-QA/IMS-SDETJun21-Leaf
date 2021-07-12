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


//You just had a weekend to forget about this so here's where we left off. All the controllers etc are in but Order isn't operational.
//Current bug is on line 62 of OrderController but I doubt it's the only one, chances are though you have all of Monday to fix everything
//Then Tue-Thu to implement unit tests and do documentation stuff. Sounds like a lot but 3 days is a long time and we're probably overestimating
//how long it'll take to fix the Controller. There's some other minor stuff, mainly displaying the items in each order but that's low prio.
//Other than that it's the presentation which might take an afternoon and a handful of small documents. Don't ignore them but they're not too much effort
//Don't forget to take the occasional screen grab of the Jira board, maybe one mid-Monday and one like Wednesday?

//Also as a stretch goal, when creating an order you could display the items available. Not part of MVP but QoL for user