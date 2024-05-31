# Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

# Add Maintainer Info
LABEL maintainer="ponsianodeloor@example.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's war file
ARG WAR_FILE=target/account-0.0.1-SNAPSHOT.war

# Add the application's war to the container
ADD ${WAR_FILE} account.war

# Run the war file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/account.war"]