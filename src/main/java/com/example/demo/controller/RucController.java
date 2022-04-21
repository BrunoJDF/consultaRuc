package com.example.demo.controller;

import com.example.demo.model.dto.RucDto;
import com.example.demo.service.RucService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("ruc")
public class RucController {
    final RucService rucService;


    @PostMapping()
    Mono<?> save (@RequestParam("tipo") String tipo, @RequestParam("ruc") String ruc){
        return rucService.save(tipo, ruc).map(ResponseEntity::ok);
    }

    @GetMapping("{ruc}")
    Mono<?> getRuc(@PathVariable("ruc") String ruc){
        return rucService.getRuc(ruc).map(ResponseEntity::ok);
    }
}
