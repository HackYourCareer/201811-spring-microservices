# 201811-spring-microservices

Microservices application presented on Hack your career lecture on 06.11.2018.

##What it does

It manages Beer entity through simple CRUD REST API and provide API to rate chosen beer.


Application exposes following methods (when started through provided docker-compose):
 * `GET http://locahost:8040/catalog/beer` which returns all the beers from the db
 * `GET http://locahost:8040/catalog/beer/ID` which returns a beer with requested ID, if such does not exist null is returned
 * `POST http://locahost:8040/catalog/beer` which creates new beer and accepts following request body:
```json
{
  "id": 1,
  "name": "Name",
  "description": "Description",
  "alcoholContent": 10.0,
  "ibu": 10
}
```
* `PUT http://locahost:8040/catalog/beer/{ID}` which modifies beer with the requested ID, note that request body requires you to provide all data.
* `DELETE http://locahost:8040/catalog/beer/{ID}` which removes beer with requested ID form db 
 * `GET http://locahost:8040/rating/beer/ID` which returns a overall rating for beer with requested ID, if such does not exist null is returned
 * `POST http://locahost:8040/rating/beer/ID` which creates new rating for beer and accepts following request body:
```json
{
	"rating":5
}
```
* `DELETE http://locahost:8040/rating/beer/{ID}` which removes all ratings for beer with requested ID

## Getting started
This project require Docker and Docker Compose (which is included in Docker installation in most cases). Description on Docker installation could be found on official docker site - both for [macOs](https://docs.docker.com/docker-for-mac/install/) and [Windows](https://docs.docker.com/docker-for-windows/install/). To run application only docker-compose.yaml file is needed - in directory containing this file use command in terminal
```
docker-compose up
```

Be aware that it could take some time to start and after that, first requests could take longer than usual due to lazy initialization of underlying components (Hystrix threadpools, beans etc).

When extending this solution with custom changes docker plugin has to be configured in pom file of every service - it has to point to specific docker hub repository. More info about docker plugin could be found [here](https://github.com/fabric8io/docker-maven-plugin). With changed images - in different docker repository, docker-compose.yaml file has to be adjusted -  every changed image has to be provided in "image:" tab with following manner {YOUR_ACCOUNT_NAME}/{YOUR_REPOSITORY_NAME}