
Setup Instructions
====================================================

Tech used in this app:
- Java 8
- mysql database
- Spring MVC

To run the application, follow the steps below:


1. Install MySQL database
2. Run the database script in the folder `mySpringCustomerApp/src/com/luv2code/sql/` to create a user and load sample data
     - sql-scripts/02-customer-tracker.sql
3. Open the source code for the appropriate version
4. Run the application:
     - Select the root project folder
     - Right-Click, select Run As > Run On Server
     - Note that you will also need to install Apache Tomcat 8 or higher  
     
        
App description
====================================================

The app offers the user functions to create, delete, update and read customer entities from the database using hibernate and user interfaces (see folder ``/mySpringCustomerApp/WebContent/WEB-INF/view``)
     
