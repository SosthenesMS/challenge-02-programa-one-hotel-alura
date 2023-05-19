package com.challenge.hotel.alura.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.hotel.alura.model.Hospede;
import com.challenge.hotel.alura.repository.HospedesRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class HospedeService {

    @Autowired
    private HospedesRepository hospedesRepository;

    public List<Hospede> listarTodosOsHospedes() {
        return hospedesRepository.findAll();
    }

    public Optional<Hospede> obterHospedePeloId(int id) {
        return hospedesRepository.findById(id);
    }

    public void criarNovoHospede(Hospede hospede) {
        hospedesRepository.save(hospede);
    }

    public void atualizarDadosDoHospede(Hospede hospede) {
        int idDoHospede = hospede.getIdHospede();
        Optional<Hospede> hospedeBuscado = obterHospedePeloId(idDoHospede);
        if (hospedeBuscado.isPresent()) {
            hospedesRepository.save(hospede);
        } else {
            throw new EntityNotFoundException("Cadastro não localizado! Id do hóspede: " + idDoHospede);
        }
    }

    public void deletarCadastroDoHospede(int id) {
        hospedesRepository.deleteById(id);
    }

}
