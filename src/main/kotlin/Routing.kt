package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.html.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondHtml {
                head {
                    title { +"Iglesia Cristiana Fuente de Vida" }
                    style {
                        unsafe {
                            +"""
                            body {
                                font-family: Arial, sans-serif;
                                text-align: center;
                                margin: 20px;
                                background-color: #f4f6f7;
                                color: #2c3e50;
                            }
                            h1 {
                                color: #34495e;
                                margin-bottom: 10px;
                            }
                            h2 {
                                color: #16a085;
                                margin-top: 30px;
                            }
                            ul {
                                list-style-type: none;
                                padding: 0;
                            }
                            li {
                                margin: 5px 0;
                            }
                            .contacto {
                                margin-top: 30px;
                            }
                            .card {
                                background: white;
                                padding: 20px;
                                border-radius: 10px;
                                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                                margin: 20px auto;
                                max-width: 500px;
                            }
                            """.trimIndent()
                        }
                    }
                }
                body {
                    h1 { +"Bienvenido a la Iglesia Cristiana fraternidad Bogota" }
                    p { +"somos familia." }

                    div("card") {
                        h2 { +"Próximos eventos" }
                        ul {
                            li { +"Culto dominical: Domingo 10:00 AM" }
                            li { +"celula : Sábado 6:00 PM" }
                            li { +"Estudio bíblico: Miércoles 7:30 PM" }
                        }
                    }

                    div("card contacto") {
                        h2 { +"Contáctanos" }
                        p { +"📍 Dirección: salon comunal balcones de vista hermosa calle 190 a # 1-04, codito usaquen" }
                        p { +"📞 Teléfono: +57 321 996 55 12" }
                        p { +"📧 Correo: " }
                    }
                }
            }
        }
    }
}