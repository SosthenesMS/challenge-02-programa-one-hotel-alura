package com.challenge.hotel.alura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.hotel.alura.model.Hospede;

public interface HospedesRepository extends JpaRepository<Hospede, Integer> {
    
}
