# 1. Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# 2. Set the working directory inside the container
WORKDIR /app

# 3. Copy the JAR file into the container
COPY build/libs/*.jar app.jar

# 4. Expose port 10000
EXPOSE 10000

# 5. Run the application on port 10000
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=10000"]

#docker build -t forlink-nation .
#docker run --name forlink-nation -d -p 10001:10001 forlink-nation
#docker network connect forlink-network forlink-nation