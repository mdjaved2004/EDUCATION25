# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM tomcat:9.0-jdk17-openjdk-slim

# Purane apps delete karein
RUN rm -rf /usr/local/tomcat/webapps/*

# Yahan dhyaan dein: EDUCATION25.war ko copy kar rahe hain
COPY --from=build target/EDUCATION25.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]