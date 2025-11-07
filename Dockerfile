FROM alpine:3.18
RUN apk add --no-cache openjdk17
WORKDIR /app
COPY app.jar .
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
