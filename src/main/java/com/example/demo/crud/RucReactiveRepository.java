package com.example.demo.crud;

import com.example.demo.model.entity.RucEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface RucReactiveRepository extends ReactiveMongoRepository<RucEntity, UUID> {
    public Mono<RucEntity> getByIdc(String ruc);
}
