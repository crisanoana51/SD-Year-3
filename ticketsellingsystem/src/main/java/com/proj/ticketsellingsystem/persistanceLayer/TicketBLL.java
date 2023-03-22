package com.proj.ticketsellingsystem.persistanceLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proj.ticketsellingsystem.modelData.Ticket;

import java.util.List;

public interface TicketBLL extends JpaRepository<Ticket, Integer> {

    Ticket getTicketById(int id);


    void deleteTicketById(int id);
}
