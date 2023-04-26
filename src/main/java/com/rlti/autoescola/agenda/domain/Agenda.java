package com.rlti.autoescola.agenda.domain;

import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAgenda;

    @OneToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    @OneToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @Enumerated(EnumType.STRING)
    private TipoAula tipoAula;
    private LocalDate data;
    private HorarioAula horarioAula;
    private BigDecimal horaAulaRealizada;

    public Agenda(Instrutor instrutor, Matricula matricula, Veiculo veiculo, AgendaRequest request) {
        this.instrutor = instrutor;
        this.matricula = matricula;
        this.veiculo = veiculo;
        this.tipoAula =  request.getTipoAula();
        this.data = request.getData();
        this.horarioAula = request.getHorarioAula();
        this.horaAulaRealizada = request.getHoraAulaRealizada();
    }
}
