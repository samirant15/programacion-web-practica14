FROM adoptopenjdk/openjdk8:alpine-jre

VOLUME /app

COPY /build/libs/practica13-0.0.1-SNAPSHOT.jar app.jar

#RUN chmod +x entrypoint.sh

ENTRYPOINT ["java", "-jar", "app.jar"]