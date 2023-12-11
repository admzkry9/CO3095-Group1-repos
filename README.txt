# Setting Up the Database

## Prerequisites

Before setting up the database, ensure you have the following installed:

- MySQL Server
- MySQL Workbench

## Database Setup

1. **Install MySQL Server**:
   Download and install the MySQL Server from the official website. Follow the installation guide provided to set up the MySQL Server on your machine.

2. **Install MySQL Workbench**:
   Download and install MySQL Workbench, which will be used to interact with your database.

3. **Create a New Connection in Workbench**:
   Open MySQL Workbench and create a new connection to your local MySQL server instance. Use the default settings or configure them as needed for your setup.

## Configure Application Properties

1. **Update Credentials**:
   Navigate to the application properties file in your project directory (Resources folder). Update the database credentials to match the username and password you set up for your MySQL server.

spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
spring.datasource.username=your-username
spring.datasource.password=your-password

## Access Source Code

1. **Find Main.java**:
Access the source code by navigating to the following path in your project folder:  CO3095-Group1-repos/src/main/java/jobAdvertising/Main.java

2. **Compile and Run**:
Compile and run `Main.java` to start the application. Ensure you have the Java Development Kit (JDK) installed to compile and run the Java application.

## Running Test Cases

- All test cases are located in the `Test cases` folder within the project directory. To run the test cases, navigate to the folder and follow the instructions specific to your development environment or IDE.