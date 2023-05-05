package com.rlti.autoescola.agenda.domain;

import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    @OneToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @OneToOne()
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @Enumerated(EnumType.STRING)
    private TipoAula tipoAula;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private HorarioAula horarioAula;

    public Agenda(Instrutor instrutor, Matricula matricula, Veiculo veiculo, AgendaRequest agendaRequest) {
        this.instrutor = instrutor;
        this.matricula = matricula;
        this.veiculo = veiculo;
        this.data = agendaRequest.getData();
        this.horarioAula = agendaRequest.getHorarioAula();
        this.tipoAula = agendaRequest.getTipoAula();
    }
}