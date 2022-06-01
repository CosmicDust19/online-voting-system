## HOW TO RUN

- Database configurations:
  - Be sure that MySQL (Xampp is recommended) installed on your computer (MySQL5 InnoDB Dialect used in this project).
  - Mysql home path will be determined and started automatically after first run, but it ***requires to mysql running*** at first.
  - Default database username is "root" and password is empty (MySQL defaults). Change if your username and password are different (from ovs-server/src/main/resources/application.properties).
- Java configurations:
  - At least ***JDK 17*** should be installed (Download JDK 17 [from here](https://www.oracle.com/java/technologies/downloads/#jdk17-windows) and set its environment variable as [shown in here](https://www.geeksforgeeks.org/how-to-set-java-path-in-windows-and-linux/)).
  - ***Maven*** should be installed (Download Maven [from here](https://maven.apache.org/download.cgi) and set its environment variable as [shown in here](https://www.qamadness.com/knowledge-base/how-to-install-maven-and-configure-environment-variables/)).
- Run "mvn clean spring-boot:run" in root project directory (ovs-server) to see controllers at [localhost:8080](http://localhost:8080/swagger-ui/index.html#) in your browser.
