# Variables
APP_NAME=my-java-api
JAR_FILE=target/app.jar

# Default target
all: package docker-build

# Compile & package with Maven
package:
	mvn clean package

# Build Docker image
docker-build:
	docker build -t $(APP_NAME) .

# Run container
run:
	docker run -p 8080:8080 $(APP_NAME)

# Push code to GitHub
push:
	git add .
	git commit -m "Auto commit from Makefile"
	git push origin main

# Full pipeline
deploy: package docker-build push