package com.example.demo.service;

import com.example.demo.controller.advice.AlreadyExistException;
import com.example.demo.controller.advice.NotFoundException;
import com.example.demo.model.dto.RucDto;
import com.example.demo.repository.RucRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class RucService {

    final RucRepository repository;

    public Mono<Optional<RucDto>> save(String tipo, String ruc) {
        return repository.getByRuc(ruc).doOnNext(rucDto -> {
            WebClient.create("http://wsruc.com/Ruc2WS_JSON.php")
                    .get().uri(uriBuilder ->
                            uriBuilder.queryParam("tipo", tipo)
                                    .queryParam("ruc", ruc).build()
                    ).exchangeToMono(client -> client.bodyToMono(RucDto.class))
                    .subscribe();
            if(rucDto.isEmpty()){
                repository.save(rucDto.get()).subscribe();
            } else {
                try {
                    throw new AlreadyExistException("Ya existe ruc");
                } catch (AlreadyExistException e) {
                    e.printStackTrace();
                }
            }

        }).switchIfEmpty(Mono.error(new NotFoundException("No existe ruc")));
    }

    public Mono<Optional<RucDto>> getRuc(String ruc){
        return repository.getByRuc(ruc);
    }
}
