
Setup Instructions
====================================================

To run the application, follow the steps below:


1. Install MySQL database
2. Run the database scripts to create a user and load sample data
     - sql-scripts/01-create-user.sql
     - sql-scripts/02-customer-tracker.sql
3. Open the source code for the appropriate version
4. Run the application:
     - Select the root project folder
     - Right-Click, select Run As > Run On Server
     - Note that you will also need to install Apache Tomcat 8 or higher  
     
        
App description
====================================================

The app offers the user the change to create, delete, update and read customer entities from the database using hibernate and user interfaces (see folder ``/mySpringCustomerApp/WebContent/WEB-INF/view``)
     