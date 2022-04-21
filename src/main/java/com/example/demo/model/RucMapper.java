package com.example.demo.model;

import com.example.demo.model.dto.RucDto;
import com.example.demo.model.entity.RucEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RucMapper {
    @Mappings({
            @Mapping(source = "ruc", target = "idc"),
            @Mapping(source = "ubigeo", target = "ubi"),
            @Mapping(source = "razon_social", target = "businessName"),
            @Mapping(source = "provincia", target = "locationProv"),
            @Mapping(source = "departamento", target = "locationDepartment"),
            @Mapping(source = "distrito", target = "locationDistrict"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "estado", target = "status"),
    })
    RucEntity toRucEntity (RucDto rucDto);

    @InheritInverseConfiguration
    RucDto toRucDto(RucEntity entity);
}
