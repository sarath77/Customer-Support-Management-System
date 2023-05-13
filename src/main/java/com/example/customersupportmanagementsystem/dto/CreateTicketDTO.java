package com.example.customersupportmanagementsystem.dto;

import lombok.Data;

@Data
public class CreateTicketDTO {
    String title;
    String description;
    Long adminUserId;
    Long createdByUserId;
}
