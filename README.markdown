Spring MVC + MyBatis + Flyway
==========================
MyBatis
-----------
MyBatis-Spring adapter is an easy-to-use Spring3 bridge for MyBatis sql mapping framework.

Flyway
----------
Flyway should be a fundamental part of any Java EE application devops. It simplifies database migration and seamlessly integrates with your application lifecycle.

Compilling
---------------
to compile project with **Jetty** add the following lines to pom.xml file
```
<plugin>
  <groupId>org.eclipse.jetty</groupId>
  <artifactId>jetty-maven-plugin</artifactId>
  <version>9.2.11.v20150529</version>
     <configuration>
       <scanIntervalSeconds>10</scanIntervalSeconds>
       <webApp>
          <contextPath>/</contextPath>
       </webApp>
	 </configuration>
 </plugin>
```

 1. Create schema data Base : *testMyBatis*
 2. Do migrate with Flyway
 3. run the following commands :
```
mvn jetty:run
```
Unit Testing
------------------
Unit testing are implementing with **JUnit** and **Mockito**

Tutorial
-----------

 1. Open the browser : go to localhost:8080
 2. login/pass : ***rod***/***koala***
