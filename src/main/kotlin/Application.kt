package com.github.adamarguti

import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080
    embeddedServer(Netty, port = port, host = "0.0.0.0") {
        // las rutas (/, /qr, etc.) están en Routing.kt -> configureRouting()
        configureRouting()
    }.start(wait = true)
}






