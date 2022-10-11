package br.com.letscode.agrocinetickets.compraringressos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comprasingressos/hello")
public class HelloController {

    @GetMapping("echo")
    public String echo() {
        return "Compras Ingresso";
    }

}
