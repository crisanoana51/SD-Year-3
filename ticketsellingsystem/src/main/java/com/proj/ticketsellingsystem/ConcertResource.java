package com.proj.ticketsellingsystem;

import com.proj.ticketsellingsystem.businessLayer.ConcertService;

import com.proj.ticketsellingsystem.modelData.Concert;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concert")
public class ConcertResource {

    private final ConcertService concertService;

    public ConcertResource(ConcertService ticketService) {
        this.concertService = ticketService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Concert>> getAllConcerts(){
        List<Concert> concerts = concertService.findAllConcerts();
        return new ResponseEntity<>(concerts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Concert> addConcert(@RequestBody Concert concert){
        Concert newConcert = concertService.addConcert(concert);
        return new ResponseEntity<>(newConcert, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Concert> updateConcert(@RequestBody Concert concert){
        Concert updateConcert = concertService.updateConcert(concert);
        return new ResponseEntity<>(updateConcert, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteConcert(@PathVariable("id") int id){
        concertService.deleteConcert(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
