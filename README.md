# Krystal Distribution Group (backend)

## Description

### About
Krystal Distribution Group is a personal project developed for the "Programming 6" course. 
The aim was to create a robust and scalable platform for managing port operations. 

### Architecture
The project employs a hexagonal architecture and utilizes a microservices approach.

Bounded contexts:
1. **Warehouse**: Manages inventory, storage, and order fulfillment within the warehouse.
2. **Landside**: Oversees all land-based operations, including appointment scheduling, truck arrival/departure coordination, and gate management.
3. **Waterside**: Handles all maritime operations, including ship arrival/departure management.
4. **Invoicing**: (Planned for future implementation)

### Technologies used:
* Spring Boot
* REST API
* RabbitMQ
* Docker
* PostgreSQL

## How to run:
```shell
docker-compose up -d
```

For the initial run, it is recommended to start the services in the following order to ensure proper initialization of RabbitMQ queues:
1. Warehouse
2. Landside
3. Waterside
4. Invoicing