FROM openjdk:8-jre-alpine
ADD target/book-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "sleep 10s && java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
