package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class RucDto {
    private String ruc;
    private String razon_social;
    private String estado;
    private String direccion;
    private String ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;
}
