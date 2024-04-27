# Docker runs instructions in a Dockerfile in order. 
# A Dockerfile must begin with a FROM instruction. 
# ARG is the only instruction that may precede FROM in the Dockerfile. 
# The FROM instruction specifies the Parent Image from which you are building.

# FROM [--platform=<platform>] <image>[:<tag>] [AS <name>]
FROM eclipse-temurin:17-jdk-alpine
# Always specify the tag/version, otherwise, it will be set to the latest that might change in time
# Note: for ARM-based processors, eclipse-temurin:17-jdk-alpine will fail, thus, use "FROM --platform=linux/amd64 eclipse-temurin:17-jdk-alpine".

# The WORKDIR instruction sets the working directory for any RUN, CMD, ENTRYPOINT, COPY and ADD instructions that follow it in the Dockerfile.
# WORKDIR /path/to/workdir 

# COPY <src>... <dest>
# The COPY instruction copies new files or directories from <src> and adds them to the filesystem of the container at the path <dest>.
# COPY . . without specifying a WORKDIR will copy everything from the project root directory to container root directory -not recomanded

COPY target/*.jar app.jar

# The EXPOSE instruction informs Docker that the container listens on the specified network ports at runtime.
# EXPOSE <port> [<port>/<protocol>...]

EXPOSE 8080
# Regardless of the EXPOSE settings, you can override them at runtime by using the -p flag. For example
# $ docker run -p 8080:8080

# An ENTRYPOINT allows you to configure a container that will run as an executable.
# ENTRYPOINT includes the commands we need to execute in order to run this application.
ENTRYPOINT ["java", "-jar", "/app.jar"]