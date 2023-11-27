FROM --platform=linux/x86_64 eclipse-temurin:17-jdk AS build

EXPOSE 8012

VOLUME /tmp

# Server
ENV PORT="PORT"

# RabbitMQ
ENV RABBITMQ_HOST="RABBITMQ_HOST"
ENV RABBITMQ_PORT="RABBITMQ_PORT"
ENV RABBITMQ_USERNAME="RABBITMQ_USERNAME"
ENV RABBITMQ_SECRET_KEY="RABBITMQ_SECRET_KEY"

# Database
ENV POSTGRES_USERNAME="POSTGRES_USERNAME"
ENV POSTGRES_PASSWORD="POSTGRES_PASSWORD"
ENV POSTGRES_URL="POSTGRES_URL"


# Keycloak
ENV KEYCLOAK_REALM="KEYCLOAK_REALM"
ENV KEYCLOAK_OPEN_ID="KEYCLOAK_OPEN_ID"


# Eureka
ENV EUREKA_SERVER_URI="EUREKA_SERVER_URI"

#Zipkin
ENV ZIPKIN_SERVER_URI="ZIPKIN_SERVER_URI"

# Config server
ENV CONFIG_SERVER_URI="CONFIG_SERVER_URI"
ENV CONFIG_SERVER_PROFILE="CONFIG_SERVER_PROFILE"


ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app


ENTRYPOINT ["java","-cp","app:app/lib/*","bo.edu.ucb.mabrequest.MabRequestApplication"]