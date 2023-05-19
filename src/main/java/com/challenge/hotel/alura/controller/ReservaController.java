package com.challenge.hotel.alura.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.hotel.alura.model.Reserva;
import com.challenge.hotel.alura.service.ReservasService;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaController {

    @Autowired
    private ReservasService reservasService;
    
    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodasAsReservas() {
        return ResponseEntity.status(HttpStatus.OK).body(reservasService.listarTodasAsReservas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Reserva>> obterReservaPeloId(@PathVariable("id") int id) {
        Optional<Reserva> reserva = reservasService.obterReservaPeloId(id);
        return ResponseEntity.status(HttpStatus.OK).body(reserva);
    }


    @PostMapping
    public ResponseEntity<Object> criarNovaReserva(@RequestBody Reserva reserva) {
        try {
            reservasService.criarNovaReserva(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao tentar criar, verifique os dados novamente!" + ex.getMessage());
        }
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarReservaPeloId(@PathVariable("id") int id) {
        reservasService.deletarReservaPeloId(id);
        return ResponseEntity.ok().body("Reserva deletada com sucesso!");
    }
     
    
    @PutMapping
    public ResponseEntity<Object> atualizaraReserva(@RequestBody Reserva reserva) {
        try {
            reservasService.atualizarInformacoesDaReserva(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
