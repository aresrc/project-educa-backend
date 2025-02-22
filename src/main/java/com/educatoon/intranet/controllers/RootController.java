package com.educatoon.intranet.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootController {

    @GetMapping("/")
    public String root() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Aplicación Spring Boot</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>¡Aplicación Spring Boot en ejecución!</h1>\n" +
                "    <p>Esta es la página de inicio de tu aplicación Spring Boot.</p>\n" +
                "</body>\n" +
                "</html>";
    }
}
