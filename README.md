Coverage: 80.9%
# Fundamental Project: Inventory Management System (IMS)

To create a functional application – using supporting tools, methodologies, and technologies – which encapsulates all fundamental modules covered during training.
Specifically, you are required to create an application using the language from your Programming Fundamentals week which interacts with a managed database. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Git download [https://git-scm.com/downloads]
Eclipse download [https://www.eclipse.org/downloads/]

### Installing

A step by step series of examples that tell you how to get a development env running

Copy this project url: https://github.com/simonwhiteQA/IMS-JUNESDET.git
Open Git bash
Git clone the project url to your workspace.
Open Eclipse IDE
The maven project should now be available for development and testing 

To access the IMS from Eclipse, run the "Runner.java" class.
Try and enter the following commands when prompted:
customer -> create -> Bob -> Jenkins 
This should create customer [id, "Bob", "Jenkins"]


## Running the tests

Running automated tests:

*The whole system*: Right click IMSJUNESDET/src/test/java/ in Eclipse -> coverage as -> junit test
This will return all the unit tests and the coverage the tests cover for the system.

*Controller tests*: Right click IMSJUNESDET/src/test/java/com.qa.ims.contollers in Eclipse -> run as -> junit test
This will return all the unit tests included in the controllers package for customer, item and order classes.

*Dao tests*: Right click IMSJUNESDET/src/test/java/com.qa.ims.dao in Eclipse -> run as -> junit test
This will return all the unit tests included in the data access object package for customer, item, order and order_item classes.

*Domain system*: Right click IMSJUNESDET/src/test/java/com.qa.ims.domain in Eclipse -> run as -> junit test
This will return all the unit tests included in the domain package for customer, item and order classes.

### Unit Tests 

Explain what these tests test, why and how to run them

Unit testing is a testing approach that targets the very fundamental building blocks of an application, the idea is to prove that each 'unit' of the application is functioning as expected. This is an automated process that can be run by performing the follwing:

*Controller Tests*
Test location: IMSJUNESDET/src/test/java/
Package: com.qa.ims.contollers
Description: The controller tests run unit testing for the customer, item and order controllers and their respective methods.

*DAO Tests*
Test location: IMSJUNESDET/src/test/java/
Package: com.qa.ims.dao
Description: The dao tests run unit testing for the customer, item, order and order_item data access objects and their respective methods.

*Domain Tests*
Test location: IMSJUNESDET/src/test/java/
Package: com.qa.ims.domain
Description: The domain tests run unit testing for the customer, item and order to ensure the classes hash code and equals are verified.

## Deployment

After *cloning* the repository to Git you will be able to run the IMS system on command line via the jar file:
Eclipse -> right click project file -> properties -> location (show in system explorer) -> right click -> git bash here
-> cd target -> java -jar jar[FileNameIncludingDependencies].jar 
**ensure the jar file you run is the file that includes dependencies in order for the IMS system to function as intended**

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Simon White** -  [simonwhite](https://github.com/simonwhiteQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

I would like to thank Alan Davis and Pawel Stypulkowski for their continued help throughout the process of developing this IMS project. Also, for the training they provided in the weeks upcoming to this project to ensure I was prepared to tackle the task efficiently.

I would like to further my thanks to Niall Duggan and Megan Crouch for their support as part of Team 4 to give assistance when blockers occured.
