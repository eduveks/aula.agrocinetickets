package br.com.letscode.agrocinetickets.notificacoesemail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notificacoesemail/hello")
public class HelloController {

    @GetMapping("echo")
    public String echo() {
        return "Notificações E-mail";
    }

}
