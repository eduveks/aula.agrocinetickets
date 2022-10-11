package br.com.letscode.agrocinetickets.lugaresdisponiveis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/lugaresdisponiveis/lugar")
public class LugarController {

    @GetMapping("disponiveis")
    public ResponseEntity<?> disponiveis() {
        return ResponseEntity.of(
                Optional.of(
                        new ArrayList() {{
                            add(
                                    new HashMap<>() {{
                                        put("fila", "1");
                                        put("coluna", "A");
                                    }}
                            );
                            add(
                                    new HashMap<>() {{
                                        put("fila", "2");
                                        put("coluna", "A");
                                    }}
                            );
                            add(
                                    new HashMap<>() {{
                                        put("fila", "1");
                                        put("coluna", "B");
                                    }}
                            );
                            add(
                                    new HashMap<>() {{
                                        put("fila", "2");
                                        put("coluna", "B");
                                    }}
                            );
                        }}
                )
        );
    }
}
