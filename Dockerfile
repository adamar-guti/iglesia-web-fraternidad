# --------------------------
# Etapa 1: build
# --------------------------
FROM eclipse-temurin:21-jdk-alpine AS build

# Directorio de la app
WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Dar permisos a gradlew y generar fatJar
RUN chmod +x gradlew && ./gradlew clean fatJar

# --------------------------
# Etapa 2: runtime
# --------------------------
FROM eclipse-temurin:21-jre-alpine

# Directorio de la app
WORKDIR /app

# Copiar solo el fat JAR desde la etapa de build
COPY --from=build /app/build/libs/ktor-sample-0.0.1-all.jar app.jar

# Puerto que asignará Render
ENV PORT=8080
EXPOSE 8080

# Ejecutar la app usando el puerto asignado
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=$PORT"]








