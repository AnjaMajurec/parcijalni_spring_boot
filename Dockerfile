FROM openjdk:21-jdk
MAINTAINER apis-it.hr

COPY target/Spring_parcijalniIspist-0.0.1-SNAPSHOT.jar spring_boot_parcijalni.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/spring_boot_parcijalni.jar"]