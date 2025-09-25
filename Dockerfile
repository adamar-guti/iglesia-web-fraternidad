# Etapa 1: build
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Generar el fatJar dentro del contenedor
RUN ./gradlew clean fatJar

# Etapa 2: runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar solo el JAR final desde la etapa de build
COPY --from=build /app/build/libs/ktor-sample-0.0.1-all.jar app.jar

# Puerto de la app (Render usará la variable PORT)
ENV PORT=8080
EXPOSE 8080

# Ejecutar la app usando el puerto asignado
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=$PORT"]







