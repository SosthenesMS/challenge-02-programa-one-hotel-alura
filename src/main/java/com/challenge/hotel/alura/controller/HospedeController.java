package com.challenge.hotel.alura.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.hotel.alura.model.Hospede;
import com.challenge.hotel.alura.service.HospedeService;

@RestController
@RequestMapping(value = "/hospedes")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @GetMapping
    public ResponseEntity<List<Hospede>> obterListaDeTodosOsHospedes() {
        return ResponseEntity.status(HttpStatus.OK).body(hospedeService.listarTodosOsHospedes());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Hospede>> obterHospedePeloId(@PathVariable("id") int id) {
        Optional<Hospede> hospede = hospedeService.obterHospedePeloId(id);
        return ResponseEntity.status(HttpStatus.OK).body(hospede);
    }

    @PostMapping
    public ResponseEntity<Object> criarNovoHopede(@RequestBody Hospede hospede) {
        try {
            hospedeService.criarNovoHospede(hospede);
            return ResponseEntity.status(HttpStatus.CREATED).body(hospede);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao tentar criar, verifique os dados novamente! " + ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizarDadosDoHopede(@RequestBody Hospede hospede) {
        try {
            hospedeService.atualizarDadosDoHospede(hospede);
            return ResponseEntity.status(HttpStatus.CREATED).body(hospede);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarHospedePeloId(@PathVariable("id") int id) {
        hospedeService.deletarCadastroDoHospede(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cadastro deletado com sucesso! ");
    }
}
