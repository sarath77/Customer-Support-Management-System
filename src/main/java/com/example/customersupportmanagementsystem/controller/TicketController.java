package com.example.customersupportmanagementsystem.controller;

import com.example.customersupportmanagementsystem.dto.AssignSupportDTO;
import com.example.customersupportmanagementsystem.dto.CreateTicketDTO;
import com.example.customersupportmanagementsystem.dto.UpdateTicketDTO;
import com.example.customersupportmanagementsystem.dto.UpdateTicketStatusDTO;
import com.example.customersupportmanagementsystem.exception.DataNotFoundException;
import com.example.customersupportmanagementsystem.model.Ticket;
import com.example.customersupportmanagementsystem.model.TicketStatus;
import com.example.customersupportmanagementsystem.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all/{userId}")
    public List<Ticket> getTicketsForUser(@PathVariable Long userId) {
        return ticketService.getTicketsForUser(userId);
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable Long ticketId) throws DataNotFoundException {
        return ticketService.getTicket(ticketId);
    }

    @PostMapping
    public Long createTicket(@RequestBody CreateTicketDTO createTicketDTO) {
        Ticket ticket = new Ticket();
        ticket.setTitle(createTicketDTO.getTitle());
        ticket.setDescription(createTicketDTO.getDescription());
        ticket.setAdminUserId(createTicketDTO.getAdminUserId());
        ticket.setResidentUserId(createTicketDTO.getCreatedByUserId());
        ticket.setStatus(TicketStatus.OPEN);
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/{id}")
    public void updateTicket(@PathVariable Long id, @RequestBody UpdateTicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setTitle(ticketDTO.getTitle());
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setStatus(ticketDTO.getStatus());
        ticket.setResidentUserId(ticketDTO.getSupportPersonId());
        ticket.setAdminUserId(ticketDTO.getAdminUserId());
        ticket.setSupportPersonId(ticketDTO.getSupportPersonId());
        ticketService.updateTicket(ticket);
    }

    @PatchMapping("/support")
    public void assignSupportPersonId(@RequestBody AssignSupportDTO assignSupportDTO) throws DataNotFoundException {
        ticketService.assignSupportPersonId(assignSupportDTO);
    }

    @PatchMapping("/status")
    public void updateTicketStatus(@RequestBody UpdateTicketStatusDTO updateTicketStatusDTO) throws DataNotFoundException {
        ticketService.updateTicketStatus(updateTicketStatusDTO);

    }
}
