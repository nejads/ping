## Synopsis
This is a simple pinger application. This application can send HTTP GET request to your website and log the response in a random second between 15 minutes interval. 
This application is developed on top of Spring boot framework and you can specify your url to be pinged, inital delay and its interval in ping property file in the root of the project. 
This application is live on [**Heroku**](https://pingeropenshift.herokuapp.com/)

## Installation
If you have maven installed, download the source code and in the code directory run: 
```
mvn clean install
```

Run the application 
```
mvn spring-boot:run
```