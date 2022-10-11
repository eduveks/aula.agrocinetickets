package br.com.letscode.agrocinetickets.lugaresdisponiveis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lugaresdisponiveis/hello")
public class HelloController {

    @GetMapping("echo")
    public String echo() {
        return "Lugares Disponíveis";
    }

}
