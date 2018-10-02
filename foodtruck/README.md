# A simple User CRUD Application #

A simple application to demonstrate how to configure AngularJS with Spring Boot.

## Technologies ##
* [Spring Boot](https://spring.io/)
* [Hibernate](http://hibernate.org/)
* [AngularJS](https://angularjs.org/)
* [Karma](https://karma-runner.github.io/1.0/index.html)
* [Protractor](http://www.protractortest.org/)
* [Bootstrap](http://getbootstrap.com/)

## Prerequisites ##
* [Maven](http://maven.apache.org/download.cgi)
* [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [Node.js](https://nodejs.org)

## Configuration ##
Open the src/main/resources/application.properties file and set your own configurations.

## Run this project ##
1 . Clone project on your machine
```
#!terminal 
git clone https://gitlab.com/mihaesandrei/user-crud-example.git
```
2 . Change directory
```
#!terminal

cd user-crud-example
```
3 . Install the dependencies by running:
```
#!terminal

npm install

./node_modules/protractor/bin/webdriver-manager update
```
4 . Run the application using:
```
#!terminal

mvn spring-boot:run
```

## How to run tests ##

Running Unit Tests
```
#!terminal

node_modules/karma/bin/karma start src/test/resources/karma.conf.js
```
Running E2E Tests
```
#!terminal

node_modules/protractor/bin/protractor src/test/resources/protractor.conf.js

```