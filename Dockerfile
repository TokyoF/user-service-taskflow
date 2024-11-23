
# Usar una imagen base de JDK para ejecutar Spring Boot
FROM openjdk:17-jdk-alpine

# Copiar el archivo JAR generado
COPY target/user-management-0.0.1-SNAPSHOT.jar user-service.jar

# Exponer el puerto configurado
EXPOSE 8091

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/user-service.jar"]
