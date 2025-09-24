# Usar OpenJDK 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio de la app
WORKDIR /app

# Copiar el JAR generado (nuestro fatJar)
COPY build/libs/ktor-sample.jar app.jar

# Exponer el puerto (Render asignará el puerto real con variable PORT)
ENV PORT=8080
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]







