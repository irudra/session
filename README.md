# session
Repository for session

Requirements:

Java 8

Maven setup in machine

Build infra structure services:

Eureka server:

navigate to session/hystrix/
run below command in command prompt:

mvn clean install

run "mvn spring-boot:run" command in each of the folder in the same order: 

1: Eureka server : eureka-server

2: Turbine servier : turbine

3: Hystrix Dashboard to track hystrix command: hystrix-dashboard

4: Hystrix Example to check : hystrix-example

Build user services:

navigate to session/apps/
run below command:

mvn clean install

Run "mnv spring-boot:run"  command in the same order at each package:

1: Service with endpoint to get events and customer : customer-service

2: Service with facade like implementation to get data from different services: customer-client-service

Endpoit to check :

Eureka UI : Here you can check the services which are up:
http://localhost:8761/

Turbine stream: check the hystrix dashboard for configured services:

http://localhost:8081/hystrix/monitor?stream=http://localhost:8082/turbine.stream

Swagger UI for customer-service
http://localhost:9098/swagger-ui.html

Swagger UI for customer-client-service
http://localhost:9099/swagger-ui.html

Hystrix Dashboard to check hystrix stream of that services just replace the "localhost" and "port"(9098) in the below URL to correct value:

http://localhost:8081/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9098%2Fhystrix.stream




