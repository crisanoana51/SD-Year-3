package com.proj.ticketsellingsystem.persistanceLayer;

import com.proj.ticketsellingsystem.modelData.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertBLL extends JpaRepository<Concert, Integer> {

    //void deleteConcertById(int id);
}
