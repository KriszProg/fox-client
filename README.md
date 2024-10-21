<h1>Fox-Client Application </h1>

---
<h3>What does this Application do?</h3>

- this application is designed to act as a `client` within a __microservice__ architecture
- it communicates with other microservices _(currently integrated with one: the `parcel-handler` service)_
- the application can either forward the data received from the `parcel-handler` in its original form or combine data retrieved from different endpoints of `parcel-handler` _(e.g.: via `getParcelWithTrackingEventsByParcelNo()` feature)_
- with future integrations the `client` is able to combine data retrieved from multiple microservices
- it offers a set of [Endpoints](#Endpoints) to retrieve data
- all responses are provided in `JSON` format


<h4>IMPORTANT NOTES: </h4> 
- To ensure proper operation, please download and run the `parcel-handler` microservice from [here](https://github.com/KriszProg/parcel-handler).
- Make sure that `parcel-handler` is running correctly before starting this application.

---
<h3>Project Settings </h3>

- Language: Java 17
- Language level: 17 - Sealed types, always-strict floating-point semantics

---
<h3>Technologies & Tools </h3>

- Spring Boot (v3.3.4)
- Spring Cloud OpenFeign
- OpenApi (Swagger) (v3)


---
<h3>Building the Application </h3>

- To build the project, use Maven with this command: `mvn clean install`


---
<h3>Running the Application </h3>

- __Option_1__: use IntelliJ IDEA's Run Configuration
- ___[NOTE]___: _The application utilizes annotation processors (e.g., Lombok, Therapi), so annotation processing may need to be enabled in your IDE settings, depending on your version of IntelliJ IDEA._


- __Option_2__: 
  - [1] open a terminal and navigate to the project's root directory
  - [2] run the command: `java -jar target/fox-client-0.0.1-SNAPSHOT.jar`


- __Option_3__:
  - [1] after building the project, copy the `fox-client-0.0.1-SNAPSHOT.jar` file to a desired location  
  - [2] open a terminal and navigate to that folder
  - [3] run the command: `java -jar fox-client-0.0.1-SNAPSHOT.jar`


- Upon successful startup, the [Endpoints](#Endpoints) will be available on port `8080`.

---

<h3>Endpoints</h3>

- upon successful startup, you can assess the built-in Swagger UI at: [http://localhost:8080/fox-client/swagger-ui.html](http://localhost:8080/fox-client/swagger-ui.html) 
- here you can explore all endpoints and their detailed explanations
- the Swagger UI also allows you to interactively test each endpoint
- feel free to explore and have fun! 😊

