FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/preparation-0.0.1-SNAPSHOT.jar preparation.jar
EXPOSE 8080

# Optionally, install MySQL client if needed for debugging or other purposes
RUN apt-get update && \
        apt-get install -y --no-install-recommends mysql-client && \
        rm -rf /var/lib/apt/lists/*

# Set environment variables for MySQL connection
ENV MYSQL_HOST=mysql-server
ENV MYSQL_PORT=3306
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=Prepare@123$
ENV MYSQL_DATABASE=mysql

ENTRYPOINT ["java","-jar","preparation.jar"]