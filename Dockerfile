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

# 네트워크가 없다면 docker network create forlink-network
#docker build -t forlink-nation .
#docker run --name forlink-nation -d -p 10000:10000 forlink-nation
#docker network connect forlink-network forlink-nation