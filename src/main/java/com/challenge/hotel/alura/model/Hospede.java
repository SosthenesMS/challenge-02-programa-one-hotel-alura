package com.challenge.hotel.alura.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "hospede")
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHospede;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "sobrenome", nullable = false, length = 45)
    private String sobrenome;

    @Column(name = "dataDeNascimento")
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate dataDeNascimento;

    @Column(name = "nacionalidade", nullable = false, length = 45)
    private String nacionalidade;

    @Column(name = "telefone", nullable = false, length = 45)
    private String telefone;

    @OneToOne
    @JoinColumn(name = "idReserva")
    private Reserva reserva;
    
}
