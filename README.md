# <center>awsome-cws</center>

## E-R Diagram

Here is a entities relationship graph as below:

![](http://cdn.51leif.com/awsome-cws-er.png "E-R")

## Sources download

It's use a sample database from [here](https://launchpad.net/test-db/).

## Run

1. Add `mysql-connector-java-5.1.31.jar` to `{$tomcat-folder}\lib`.

1. Add awsome-cws-web module to Tomcat server.

1. Configure Maven Run Configuration, as below :
![](http://cdn.51leif.com/2019-1-22-maven-run-configuration.png "maven run configuration")

1. Maven Update.

1. Start the server.

## Solutions

1. If server throws `OutOfMemeryError: PermGen space`, please create `setenv.bat` file manually and put it to this path -> `{$tomcat-folder}\bin\`.

	content: `set JAVA_OPTS=-Dfile.encoding=UTF-8 -Xms128m -Xmx1024m -XX:PermSize=64m -XX:MaxPermSize=256m`