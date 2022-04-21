package com.example.demo.model.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class RucEntity {
    private String idc;
    private String businessName;
    private String status;
    private String address;
    private String ubi;
    private String locationDepartment;
    private String locationProv;
    private String locationDistrict;
}
