package com.rlti.autoescola.empresa.domain;

import com.rlti.autoescola.cliente.domain.TipoPessoa;
import com.rlti.autoescola.empresa.domain.groups.EmpresaGroupSequenceProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@GroupSequenceProvider(value = EmpresaGroupSequenceProvider.class)
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmpresa;
    @CNPJ
    private String cnpj;
    private String razaoSocial;
    private String nomeFantazia;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;
}
