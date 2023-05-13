package com.example.customersupportmanagementsystem.repository;

import com.example.customersupportmanagementsystem.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByResidentUserId(Long residentUserId);
}
