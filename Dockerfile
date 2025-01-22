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

#docker run -d --name forlink-nation -p 10000:10000 forlink-nation:10000
