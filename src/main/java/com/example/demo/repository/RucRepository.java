package com.example.demo.repository;


import com.example.demo.model.dto.RucDto;
import com.example.demo.model.entity.RucEntity;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface RucRepository {

    Mono<RucDto> save(RucDto rucDto);
    Mono<Optional<RucDto>> getByRuc(String ruc);
}
