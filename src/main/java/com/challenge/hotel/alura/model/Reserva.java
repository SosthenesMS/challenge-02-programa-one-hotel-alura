package com.challenge.hotel.alura.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

    @Column(name = "dataEntrada")
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate dataEntrada;

    @Column(name = "dataSaida")
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate dataSaida;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "formaDePagamento", nullable = false, length = 45)
    private String formaDePagamento;

    
}
