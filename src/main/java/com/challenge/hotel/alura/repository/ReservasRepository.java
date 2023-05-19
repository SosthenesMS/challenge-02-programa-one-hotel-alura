package com.challenge.hotel.alura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.hotel.alura.model.Reserva;

public interface ReservasRepository extends JpaRepository<Reserva, Integer> {
    
}
