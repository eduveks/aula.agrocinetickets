package br.com.letscode.agrocinetickets.compraringressos.controller;

import br.com.letscode.agrocinetickets.compraringressos.model.dto.IngressoDTO;
import br.com.letscode.agrocinetickets.compraringressos.model.dto.IngressoRapidoDTO;
import br.com.letscode.agrocinetickets.compraringressos.model.dto.LugarDTO;
import br.com.letscode.agrocinetickets.compraringressos.service.LugaresDisponiveisClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/comprasingressos/compra")
public class CompraController {
    private LugaresDisponiveisClienteService lugaresDisponiveisClienteService;

    public CompraController(LugaresDisponiveisClienteService lugaresDisponiveisClienteService) {
        this.lugaresDisponiveisClienteService = lugaresDisponiveisClienteService;
    }

    @PostMapping("ingresso")
    public ResponseEntity<?> ingresso(@RequestBody IngressoDTO ingressoDTO) {
        return ResponseEntity.of(
                Optional.of(
                        new HashMap() {{
                            put("result", true);
                        }}
                )
        );
    }

    @PostMapping("ingresso-rapido")
    public ResponseEntity<?> ingressoRapido(@RequestBody IngressoRapidoDTO ingressoDTO) {
        return ResponseEntity.of(
                Optional.of(
                        new HashMap() {{
                            put("result", true);
                            put("lugar", lugaresDisponiveisClienteService.lugarRandomico());
                        }}
                )
        );
    }

}
