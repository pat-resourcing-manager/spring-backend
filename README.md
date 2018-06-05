# PAT Resourcing Manager

A Spring API that manages resource allocation in a Neo4j graph database.

You need a Neo4j graph database with the Bolt running on localhost:7687.

## Data Model

The first iteration is very simple. We have people, each with a name, and skills, also with a name.
They are connected with a relationship - HAS_SKILL - which is weighted with a strength value - at this point 1-3 (3 being better at that skill).

## Endpoints

The application has the following endpoints:

### Health

The GET endpoint "/health" should return a positive response if the app is running.

### People

There are the following endpoints for people:

* GET: "/people" - retrieves all people
* GET: "/person/{name}" - retrieves person with the name parameter
* POST: "/person" - adds a new person
* PUT: "/person/{id}" - updates a person
* DELETE: "/person/{id}" - deletes a person

The POST endpoint will create a new PERSON node in the graph.