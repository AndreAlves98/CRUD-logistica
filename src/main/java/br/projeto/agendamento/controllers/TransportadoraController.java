package br.projeto.agendamento.controllers;

import br.projeto.agendamento.dto.TransportadoraRequestDto;
import br.projeto.agendamento.entidades.Transportadora;
import br.projeto.agendamento.service.TransportadoraService;
import br.projeto.agendamento.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraService transportadoraService;

    @GetMapping("/listar")
    public ResponseEntity<List<Transportadora>> listarTodos() {
        return ResponseEntity.ok(transportadoraService.listarTodos());
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody TransportadoraRequestDto transportadora) {
        try {
            return ResponseEntity
                    .status(201)
                    .body(transportadoraService.criar(transportadora));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(RequestUtil.parserMensagem(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(RequestUtil.parserMensagem(e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody TransportadoraRequestDto transportadora
    ) {
        try {
            return ResponseEntity.ok(transportadoraService.atualizar(id, transportadora));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(RequestUtil.parserMensagem(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(RequestUtil.parserMensagem(e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            transportadoraService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(RequestUtil.parserMensagem(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(RequestUtil.parserMensagem(e.getMessage()));
        }
    }
}
