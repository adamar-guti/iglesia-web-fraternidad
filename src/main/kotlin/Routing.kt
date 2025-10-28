package com.github.adamarguti

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.* // 👈 Import necesario para los archivos estáticos
import kotlinx.html.*

fun Application.configureRouting() {
    routing {

        // 📁 Servir imágenes, CSS y otros archivos desde /resources/static
        static("/static") {
            resources("static")
        }

        get("/") {
            call.respondHtml {
                head {
                    title { +"Iglesia Cristiana Fraternidad Bogotá" }
                    meta { charset = "UTF-8" }
                    meta {
                        name = "viewport"
                        content = "width=device-width, initial-scale=1.0"
                    }
                    link {
                        rel = "stylesheet"
                        href = "https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
                    }
                }
                body("bg-gray-50 text-gray-900 font-sans") {

                    // HEADER
                    header("bg-blue-900 text-white shadow-md") {
                        div("max-w-6xl mx-auto flex justify-between items-center p-4") {
                            img(src = "/static/logo.jpg", alt = "Logo Fraternidad") {
                                classes = setOf("h-12")
                            }
                            nav("space-x-6") {
                                a("/", classes = "hover:text-yellow-400") { +"Inicio" }
                                a("#eventos", classes = "hover:text-yellow-400") { +"Eventos" }
                                a("#contacto", classes = "hover:text-yellow-400") { +"Contáctenos" }
                            }
                        }
                    }

                    // HERO SECTION
                    section("bg-blue-900 text-center text-white py-20") {
                        h1("text-4xl md:text-5xl font-bold mb-4") {
                            +"Iglesia Cristiana Fraternidad Bogotá"
                        }
                        p("text-lg text-yellow-400 italic mb-6") {
                            +"yo me alegre con los que me decian a la casa de jehova iremos ... salmos 122-1.”"
                        }
                        a("#contacto", classes = "bg-yellow-500 hover:bg-yellow-400 text-blue-900 font-semibold px-6 py-3 rounded-full shadow-md transition") {
                            +"Orar por mí"
                        }
                    }

                    // EVENTOS
                    section(classes = "py-16 px-6 max-w-6xl mx-auto") {
                        id = "eventos"
                        h2("text-3xl font-bold text-blue-900 mb-10 text-center") { +"Eventos" }
                        div("grid md:grid-cols-3 gap-8") {

                            div("bg-white rounded-2xl shadow-lg overflow-hidden") {
                                img(src = "/static/culto.jpg", alt = "Culto Dominical") {
                                    classes = setOf("w-full h-48 object-cover")
                                }
                                div("p-6") {
                                    h3("text-xl font-semibold text-blue-800") { +"Culto Dominical" }
                                    p("text-gray-600 mt-2") { +"Domingo 10:00 AM" }
                                    a("#", classes = "inline-block mt-4 bg-blue-900 text-white px-4 py-2 rounded hover:bg-blue-800") { +"Registrarse" }
                                }
                            }

                            div("bg-white rounded-2xl shadow-lg overflow-hidden") {
                                img(src = "/static/celula.jpg", alt = "Célula") {
                                    classes = setOf("w-full h-48 object-cover")
                                }
                                div("p-6") {
                                    h3("text-xl font-semibold text-blue-800") { +"Célula" }
                                    p("text-gray-600 mt-2") { +"Sábado 6:00 PM" }
                                    a("#", classes = "inline-block mt-4 bg-blue-900 text-white px-4 py-2 rounded hover:bg-blue-800") { +"Registrarse" }
                                }
                            }

                            div("bg-white rounded-2xl shadow-lg overflow-hidden") {
                                img(src = "/static/estudiobiblico.jpg", alt = "Estudio Bíblico") {
                                    classes = setOf("w-full h-48 object-cover")
                                }
                                div("p-6") {
                                    h3("text-xl font-semibold text-blue-800") { +"Estudio Bíblico" }
                                    p("text-gray-600 mt-2") { +"Miércoles 7:30 PM" }
                                    a("#", classes = "inline-block mt-4 bg-blue-900 text-white px-4 py-2 rounded hover:bg-blue-800") { +"Registrarse" }
                                }
                            }
                        }
                    }

                    // CONTACTO
                    section(classes = "bg-gray-100 py-16") {
                        id = "contacto"
                        div("max-w-4xl mx-auto text-center") {
                            h2("text-3xl font-bold text-blue-900 mb-6") { +"Contáctanos" }
                            p("text-gray-700 mb-2") { +"📍 Salón Comunal Balcones de Vista Hermosa, Calle 190A #1-04, Codito Usaquén" }
                            p("text-gray-700 mb-2") { +"📞 +57 321 996 55 12" }
                            p("text-gray-700") { +"📧 contacto@fraternidadbogota.org" }
                        }
                    }

                    // FOOTER
                    footer("bg-blue-900 text-white text-center py-4 mt-10") {
                        p { +"© 2025 Iglesia Cristiana Fraternidad Bogotá — Somos Familia" }
                    }
                }
            }
        }
    }
}



