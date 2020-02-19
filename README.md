
Setup Instructions
====================================================

Tech used in this app:
- Java 8
- mysql database
- Spring MVC

To run the application, follow the steps below:


1. Install MySQL database. I suggest you to install docker and just run the following docker script to deploy an mysql server in a container: ``docker run --detach --name=mysql_springapp --env="MYSQL_ROOT_PASSWORD=24081983" --publish 6703:3306  mysql``
2. Run the database scripts in the folder `mySpringCustomerApp/src/com/luv2code/sql/` 
3. Open the source code for the appropriate version
4. Run the application:
     - Select the root project folder
     - Right-Click, select Run As > Run On Server
     - Note that you will also need to install Apache Tomcat 8 or higher  
     
        
App description
====================================================

The app offers the user functions to create, delete, update and read customer entities from the database using hibernate and user interfaces (see folder ``/mySpringCustomerApp/WebContent/WEB-INF/view``).
     
