package br.com.letscode.agrocinetickets.compraringressos.service;

import br.com.letscode.agrocinetickets.compraringressos.model.dto.LugarDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class LugaresDisponiveisClienteService {
    private RestTemplate restTemplate;
    public LugaresDisponiveisClienteService(RestTemplateBuilder restTemplateBuilder,
                                            @Value("${microservice.lugaresdisponiveis.endpoint}") String endpoint) {
        this.restTemplate = restTemplateBuilder
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .rootUri(endpoint)
                .build();
    }

    public LugarDTO lugarRandomico() {
        LugarDTO[] lugares = restTemplate.getForObject("/lugar/disponiveis", LugarDTO[].class);
        if (lugares != null && lugares.length > 0) {
            return lugares[new Random().nextInt(lugares.length)];
        }
        return null;
    }
}
