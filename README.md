# orderdemo

#Micro Service Design principles:

1. Loosely Coupled
2. Independent from external systems 
3. Independently changeable
4. Independently deployable
5. Support contracts
6. Technology agnostic API (consumers can use any technology, thirdparty systesm can use thier own APi)
7. Stateless ( Should not have to be remember what happened before)

#API architecture styles:

1. Pragmatic REST style
2. HATEOS
3. RPC
4. SOAP

REST style:
http style, web infrastructure, inherits advantages of the web, Json/XML, Resource endpoints,
uniform resource interface (http verbs) GET, PUT, POST, PATCH, DELETE, OPTIONS
Http codes standards, API does not need to know previous interactions, cachable or not cacheble based on http
infrastructures. Layered systems (load balancer of http), 
Uniform interface - noun format resources, manipulation of resources, self descriptive message

#1. Pragmatic REST style

Extended unofficial version of REST
Not all about CRUD, Action based end points, Response body, Query String or request body, Callback address, http status codes
, loosely coupled, stateless, independently deployable, changeable


#Microservice design pattern

1. Facade design pattern
2. Proxy design pattern
3. Stateless Service Pattern

# 1. Facade Design pattern:
 A signle interface to controllers(sub systems).
 Each subsystem is represented by a class
 Service is Facade : Business logic resides in Facade
 Helps with information hiding
 Shared models 
 Keep the Domain models are separate.
 Single Cohesion
 
 #steps: 
 1. Design the api
 - Edpoints, parameters, response, http status codes
 2. Mock the API: have multiple facade implementations (hard coded values and feedback from consumers)
 3. Revise and implement actual Facade
 
# 2. Proxy Design pattern:

No business logic
proxy of an original object
simplification and transformation logic (to the local context)
security details
validation
DTOs/JSONs

# 3. Stateless Service Design pattern:

no session
avoid stateful for microservices
No data should be hold in client or service
clients maintains state
scalability, availability, performance
Increased network traffic

# II) DDD and Bounded Context:

Bounded context technique for defining a microservice which was taken from DDD.

Domian, Context, Service

Use the same name belongs to the real world, this will help both domain experts and technical experts.
Business domain consists of multiple Bounded contexts.
BC represents a domain function. what is in scope and what is outside the scope. Loosely coupled.

Bounded Context: Specific responsibility enforced by an explicit boundary. Microservice design

Domains and sub-domains (internal models).
Shared models for communication.
BCs are completely independent
External and internal models different
Microservice = Bounded Context
Own repository, own database
Contarcts for BC
Logical Bounded context
Out of context
Natural language understand by both developers and domain experts.
supporting concepts and core concepts, out of context concepts.
Both parties will understand the langauge defined within the bounded context


 




 
 
 
 
 
