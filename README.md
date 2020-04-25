# User Service API
User Service REST API that registers, updates, and removes users.
The App uses SpringBoot and Swagger UI and utilizes an internal repository.

**In order to run locally:**

If using the terminal navigate to the root folder and type: `./gradlew clean build`

Then navigate to the `/build/libs` folder where a packaged version of the API will be,
run it with `java -jar <userservice-version-SNAPSHOT.jar`
________
Tests can be run with `./gradlew test`
________
There is a UI component to the API that can be accessed when running the application locally,
`localhost:8080/swagger-ui.html` which will expose all API endpoints and allow you to play with the API from the get go.

If you are interested in viewing the data without clicking through the UI, simply go to `localhost:8080/` and you will get a JSON of all the data entries.