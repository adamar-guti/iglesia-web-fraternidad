plugins {
    kotlin("jvm") version "1.9.24"
    id("io.ktor.plugin") version "2.3.12"
    application
}

group = "com.github.adamarguti"  // <- aquí corregido
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.3.12")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.12")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.12")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
    implementation("com.google.zxing:core:3.5.3")
    implementation("com.google.zxing:javase:3.5.3")
    implementation("io.ktor:ktor-server-html-builder-jvm:2.3.12")
    implementation("ch.qos.logback:logback-classic:1.4.11")

    testImplementation("io.ktor:ktor-server-tests-jvm:2.3.12")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.25")
}

kotlin {
    jvmToolchain(21)
}

application {
    // Debe apuntar a tu clase principal generada por Kotlin (ApplicationKt)
    mainClass.set("com.github.adamarguti.ApplicationKt")
}

// Generar un JAR ejecutable con todas las dependencias incluidas
tasks.register<Jar>("fatJar") {
    archiveFileName.set("ktor-sample.jar")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "com.github.adamarguti.ApplicationKt"
    }

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
}







