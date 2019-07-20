FROM adoptopenjdk/openjdk8:jre

VOLUME /app

EXPOSE 8080 8081 8082

COPY /build/libs/practica13-0.0.1-SNAPSHOT.jar app.jar

#RUN chmod +x entrypoint.sh

ENTRYPOINT ["java", "-jar", "app.jar"]