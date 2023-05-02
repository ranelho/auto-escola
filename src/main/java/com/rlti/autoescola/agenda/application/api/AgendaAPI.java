package com.rlti.autoescola.agenda.application.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Agenda", description = "Agenda APIs")
@RequestMapping("/v1/agenda")
public interface AgendaAPI{

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    AgendaIdResponse saveAgenda(@Valid @RequestBody AgendaRequest agendaRequest);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<AgendaListResponse> getAllAgenda();

    @GetMapping("{idAgenda}")
    @ResponseStatus(code = HttpStatus.OK)
    AgendaResponse getOneAgenda(@PathVariable Long idAgenda);

    @GetMapping("/instrutor/{idInstrutor}")
    @ResponseStatus(code = HttpStatus.OK)
    List<AgendaListResponse> getAllAgendaByInstrutor(@PathVariable UUID idInstrutor);

    @GetMapping("/matricula/{idMatricula}")
    @ResponseStatus(code = HttpStatus.OK)
    List<AgendaListResponse> getAllAgendaByMatricula(@PathVariable UUID idMatricula);

    @GetMapping("/veiculo/{placa}")
    @ResponseStatus(code = HttpStatus.OK)
    List<AgendaListResponse> getAllAgendaByVeiculo(@PathVariable String placa);

    @DeleteMapping(value = "/{idAgenda}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteAgenda(@PathVariable Long idAgenda);
}