package com.example.customersupportmanagementsystem.dto;

import com.example.customersupportmanagementsystem.model.TicketStatus;
import lombok.Data;

@Data
public class UpdateTicketStatusDTO {
    private Long ticketId;
    private TicketStatus status;
}
