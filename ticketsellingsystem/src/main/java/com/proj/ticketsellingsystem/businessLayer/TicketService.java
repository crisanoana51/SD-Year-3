package com.proj.ticketsellingsystem.businessLayer;
import com.proj.ticketsellingsystem.modelData.Concert;
import com.proj.ticketsellingsystem.modelData.Ticket;
import com.proj.ticketsellingsystem.persistanceLayer.ConcertBLL;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.ticketsellingsystem.persistanceLayer.TicketBLL;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private final TicketBLL ticketBLL;

    @Autowired
    private final ConcertBLL concertBLL;
    @Autowired
    public TicketService(TicketBLL ticketBLL, ConcertBLL concertBLL){
        this.ticketBLL = ticketBLL;
        this.concertBLL = concertBLL;
    }


    public Ticket addTicket(@NotNull Ticket ticket) throws Exception {
        int id = ticket.getConcertId();
        System.out.println("Concert id: " + id);
        Concert c = concertBLL.getById(id);
        System.out.println("Concert object: " + c);

        if(c.getAvailableTickets()-ticket.getNrPlaces()>=0)
            c.setAvailableTickets(c.getAvailableTickets()-ticket.getNrPlaces());
        else {
            throw  new Exception("There are no more tickets left");
        }
        concertBLL.save(c);
        return ticketBLL.save(ticket);
    }

    public List<Ticket> findAllTickets(){
        return ticketBLL.findAll();
    }

    public Ticket updateTicket(Ticket ticket){
        return ticketBLL.save(ticket);
    }

    public void deleteTicket(int id){
        ticketBLL.deleteById(id);
    }

}
