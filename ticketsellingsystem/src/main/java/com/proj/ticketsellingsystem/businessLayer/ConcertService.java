package com.proj.ticketsellingsystem.businessLayer;


import com.proj.ticketsellingsystem.modelData.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.ticketsellingsystem.persistanceLayer.ConcertBLL;

import java.util.List;
import java.util.UUID;

@Service
public class ConcertService {
    private final ConcertBLL concertBLL;

    @Autowired
    public ConcertService(ConcertBLL concertBLL)
    {
        this.concertBLL = concertBLL;
    }

    public Concert addConcert(Concert concert){

        return concertBLL.save(concert);
    }

    public List<Concert> findAllConcerts(){
        return concertBLL.findAll();
    }

    public Concert updateConcert(Concert concert){
        return concertBLL.save(concert);
    }


    public void deleteConcert(int id){
        concertBLL.deleteById(id);
    }
}
