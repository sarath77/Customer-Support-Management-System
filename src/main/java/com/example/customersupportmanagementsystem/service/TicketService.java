package com.example.customersupportmanagementsystem.service;

import com.example.customersupportmanagementsystem.dto.AssignSupportDTO;
import com.example.customersupportmanagementsystem.dto.UpdateTicketStatusDTO;
import com.example.customersupportmanagementsystem.exception.DataNotFoundException;
import com.example.customersupportmanagementsystem.model.Ticket;
import com.example.customersupportmanagementsystem.model.TicketStatus;
import com.example.customersupportmanagementsystem.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket getTicket(Long ticketId) throws DataNotFoundException {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new DataNotFoundException("Ticket with ID : " + ticketId + " not found"));
    }

    public List<Ticket> getTicketsForUser(Long userId) {
        return ticketRepository.findByResidentUserId(userId);
    }

    public Long createTicket(Ticket ticket) {
        return ticketRepository.save(ticket).getId();
    }

    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    public void updateTicketStatus(UpdateTicketStatusDTO updateTicketStatusDTO) throws DataNotFoundException {
        Ticket ticket = ticketRepository.findById(updateTicketStatusDTO.getTicketId())
                .orElseThrow(() -> new DataNotFoundException("unable to find ticket with Id : " + updateTicketStatusDTO.getTicketId()));
        ticket.setStatus(updateTicketStatusDTO.getStatus());
        ticketRepository.save(ticket);
    }

    @Transactional
    public void assignSupportPersonId(AssignSupportDTO assignSupportDTO) throws DataNotFoundException {
        Ticket ticket = ticketRepository.findById(assignSupportDTO.getTicketId())
                .orElseThrow(() -> new DataNotFoundException("unable to find ticket with Id : " + assignSupportDTO.getTicketId()));
        ticket.setSupportPersonId(assignSupportDTO.getSupportPersonId());
        ticket.setStatus(TicketStatus.SUPPORT_PERSON_ASSIGNED);
        ticketRepository.save(ticket);

    }

}
