package com.example.customersupportmanagementsystem.dto;


import lombok.Data;
import lombok.NonNull;

@Data
public class AssignSupportDTO {

    @NonNull
    private Long ticketId;
    @NonNull
    private Long supportPersonId;

}
