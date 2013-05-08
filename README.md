# **diag**
=========

## What is this?

Analysing student engagement and collaboration in online group work is always a challenging task for teachers or faciliators who are committed to moderate online collabrative learning. 

Imagine a hundrad students are using a collaborative learning forum to carry out a group learning task. Every time when a teacher want to analyse the student engagement in the group work, he or she may have to examine the log file of the forum system and manually decide the collaboration problems of indiviudal students and groups, e.g who is not contributing much in online discussions and in which group a single student is dominating the group, based on his or her teaching experience. 

The process is very time-consuming and difficult, especially when the teacher wants to repeatedly perform the analysing task.

This Java web-based system will help solve the problem.

Here is an example scenario to illustrate what functionalities that the diag system provides: 

Jack is the teacher. At one day after the group work began, Jack wishes to assess the collaboration problems for the students and groups. He opens the web browser on his desktop computer and logins the diag system. After logining in, Jack chooses to perform a new diagnosis task. Then, he selects the data files containing the student interaction data which are prepared and uploads them to the diag system. Next, the system asks him for configuring some parameters for the diagnosis task. Jack inputs the values for the parameters and clicks the ‘diagnose’ button for executing the diagnosis process. After the diagnosis process is completed, Jack can directly view the diagnostic results as tables and diagrams using his web browser. How easy and convenient this would be!

## How to run it?

### MySQL

Diag uses a MySQL database to store user credential information. You need to install a MySQL server in your computer first. After it is installed, create a new database and two tables in the database.

`database name: groupdoctor_users`  
`table1: user_roles`  
`table2: username_password`

Then insert required data into the two tables.

### Tomcat

Diag uses Tomcat as the web server. You need to install a Tomcat server in your computer. After this is completed, copy lib/mysql-connector-java-5.1.17-bin.jar to path to/apache-tomcat-7.0.19/lib

### Eclipse

It is a pure Elipse dynamic web project.

You need to copy the diag folder into the installation directory of eclipse on your computer. Then you need to import the diag project in Eclipse. 

Following that, you need to new a server (e.g. Tomcat v 7.0 Server) in Eclipse and add the diag project to the Server. Please check check server.xml contains only one context of /GroupDoctor, e.g.,

    <Context docBase="GroupDoctor" path="/GroupDoctor" reloadable="true" source="org.eclipse.jst.jee.server:GroupDoctor"/>


To run the system, start the MySQL service, start the Tomcat server and go to http://127.0.0.1:8080/GroupDoctor/ to access the web system.

====
