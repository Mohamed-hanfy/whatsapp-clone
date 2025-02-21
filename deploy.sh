#!/bin/bash

# Stop and remove existing containers
docker-compose down

# Build and start the services
docker-compose up --build -d

# Display running containers
docker ps
