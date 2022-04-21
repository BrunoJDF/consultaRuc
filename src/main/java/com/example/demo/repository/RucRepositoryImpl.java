package com.example.demo.repository;

import com.example.demo.crud.RucReactiveRepository;
import com.example.demo.model.RucMapper;
import com.example.demo.model.dto.RucDto;
import com.example.demo.model.entity.RucEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Repository
public class RucRepositoryImpl implements RucRepository{

    final RucReactiveRepository reactiveRepository;
    final RucMapper mapper;
    @Override
    public Mono<RucDto> save(RucDto rucDto) {
        return reactiveRepository.save(mapper.toRucEntity(rucDto)).map(mapper::toRucDto);
    }

    @Override
    public Mono<Optional<RucDto>> getByRuc(String ruc) {
        return reactiveRepository.getByIdc(ruc).map(entity -> Optional.of(mapper.toRucDto(entity)));
    }

}
