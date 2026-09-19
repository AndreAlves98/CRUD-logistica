package br.projeto.agendamento.controllers;


import br.projeto.agendamento.dto.AgendamentoRequestDto;
import br.projeto.agendamento.entidades.Agendamento;
import br.projeto.agendamento.service.AgendamentoService;
import br.projeto.agendamento.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {


    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Agendamento>> listarTodos() {
        return ResponseEntity.ok(agendamentoService.listarTodos());
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody AgendamentoRequestDto paciente) {
        try {
            return ResponseEntity
                    .status(201)
                    .body(agendamentoService.criar(paciente));
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
    public ResponseEntity<Agendamento> atualizar(
            @PathVariable Long id,
            @RequestBody AgendamentoRequestDto paciente
    ) {
        try {
            return ResponseEntity.ok(agendamentoService.atualizar(
                    id,paciente
            ));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(null);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            agendamentoService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(null);
        }
    }

}
