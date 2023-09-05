package br.com.ada.reactivejavasw.controller;

import br.com.ada.reactivejavasw.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/nome-cliente")
    public Mono<String> getNomeCliente() {
        return testRepository.findById(1L);
    }

}
