An example to show how to enable CORS with spring rest api.

This example supports both tomcat and jetty maven plugin.

1. start tomcat:

	mvn clean tomcat7:run

2. start jetty:

	mvn clean jetty:run

Access the following urls for testing CORS (ajax calls localhost):

	http://127.0.0.1:8080/create.html (add a new employee Alice with id 1)
	http://127.0.0.1:8080/get.html (retrieve employee with id 1)
	http://127.0.0.1:8080/update.html (update employee Alice to John)
	http://127.0.0.1:8080/delete.html (delete employee id 1)
	http://127.0.0.1:8080/test.html (bundle all methods)

The html hardcodes with http://localhost:8080