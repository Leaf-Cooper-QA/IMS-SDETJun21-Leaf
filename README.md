# Project Title

This is an Inventory Management System (IMS) implementing primarily Java and SQL. The system allows for CRUD functionality for customers, orders and items, where an order is a collection of items made by one customer

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites


This system requires the use of Java and SQL. Additionally, the Eclipse IDE is recommended. This system uses Java 1.8, later versions should also work but earlier versions may not

```
To best install these pieces of software, it is recommended to access their download pages and follow the instructions there
```

### Installing

This installation example uses the Eclipse IDE, other IDEs may differ

First, copy the link for this repository on Github

Second, in Eclipse, right click on package explorer and click 'Import'

Then select 'Projects from Git (with Smart Install)'

Select 'Clone URI'

This should automatically paste your clipboard containing the Github repository address

Click 'Next' until the window dissapears

With the folder installed, you will need to create the SQL database. The Schema required for this is in src/main/resources/sql-schema.sql

Run these SQL instructions via MySQL command line

You will also need to allow your system to see this database. Go to src/main/resources/db.properties and change the values accordingly

You should now be set up, go to the Runner class and run it, you should be presented with instructions on how to view and edit your tables

### Unit Tests 

This system includes unit tests that have 80% coverage of the main application. If you wish to run these tests, right click src/test/java and select coverage as JUnit Test

The unit tests come in 4 main groups, tests for the domains, the controllers, the DAOs and the fail-cases of the DAOs

A simple example of a unit test would be as follows:

	@Test
	public void testGetId() {
		Item apple = new Item(1l,"apple",1.00);
		Long expected = 1l;
		assertEquals(expected,apple.getId());
	}

which tests that the item.getId() method returns as expected for a generic example. Some unit tests are more complex and make use of the Mockito dependency to simulate submethods


## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use Github(http://github.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Leaf Cooper** - *Project work* 

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Thank you to supervisors Pawel and Alan for helping with complex issues
* Thank you also to Marco for help with troubleshooting
* Finally thank you to Google for holding a lot of answers to my questions
