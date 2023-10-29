FROM openjdk:17-jdk-slim
ADD target/*.jar miMicroAuth.jar
ENV JAVA_OPTS=
CMD java ${JAVA_OPTS} -jar miMicroAuth.jar