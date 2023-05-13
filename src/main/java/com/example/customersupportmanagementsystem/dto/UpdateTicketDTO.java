package com.example.customersupportmanagementsystem.dto;

import com.example.customersupportmanagementsystem.model.TicketStatus;
import lombok.Data;

import java.sql.Date;

@Data
public class UpdateTicketDTO {
    private String title;
    private String description;
    private TicketStatus status;
    private Long adminUserId;
    private Long residentUserId;
    private Long supportPersonId;
}
