package com.challenge.hotel.alura.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.hotel.alura.model.Reserva;
import com.challenge.hotel.alura.repository.ReservasRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reserva> listarTodasAsReservas() {
        return reservasRepository.findAll();
    }

    public Optional<Reserva> obterReservaPeloId(int id) {
        return reservasRepository.findById(id);
    }

    public void criarNovaReserva(Reserva reserva) {
        reservasRepository.save(reserva);
    }

    public void atualizarInformacoesDaReserva(Reserva reserva) {
        int idProcurado = reserva.getIdReserva();
        Optional<Reserva> reservaProcurada = obterReservaPeloId(idProcurado);
        if (reservaProcurada.isPresent()) {
            reservasRepository.save(reserva);
        } else {
            throw new EntityNotFoundException("Reserva não localizada! Nº da reserva: " + idProcurado);
        }
    }

    public void deletarReservaPeloId(int id) {
        reservasRepository.deleteById(id);
    }

}
