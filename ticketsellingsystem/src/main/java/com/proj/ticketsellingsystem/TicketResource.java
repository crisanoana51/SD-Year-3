package com.proj.ticketsellingsystem;

import com.opencsv.CSVWriter;
import com.proj.ticketsellingsystem.businessLayer.TicketService;

import com.proj.ticketsellingsystem.modelData.Ticket;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proj.ticketsellingsystem.businessLayer.ConcertService;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketResource {

    private final TicketService ticketService;

    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketService.findAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/export")
    public ResponseEntity<List<Ticket>> exportToCSV() throws IOException{
        List<Ticket> tickets = ticketService.findAllTickets();

        String header = "ID, NumberPlaces, ConcertID,Price";
        PrintWriter writer = new PrintWriter("C:\\Users\\Oana\\Desktop\\UTCN AC\\Facultate - anul 3\\sem2\\Software Design\\ticketsellingsystem\\tickets.csv");
        writer.println(header);

        for (Ticket ticket : tickets) {
            writer.println(ticket.toString());

        }
        writer.close();
        System.out.println("tickets exported");

        return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);


    }


    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) throws Exception {
        System.out.println(ticket);
        Ticket newTicket = ticketService.addTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket){
        Ticket updateTicket = ticketService.updateTicket(ticket);
        return new ResponseEntity<>(updateTicket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") int id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
