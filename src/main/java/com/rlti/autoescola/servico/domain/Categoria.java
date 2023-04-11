package com.rlti.autoescola.servico.domain;

import com.rlti.autoescola.matricula.domain.TipoServico;

public enum Categoria {
    ACC, A, B, C, D, E, AB;

    public boolean isValidTipoServico(TipoServico tipoServico) {
        return switch (tipoServico) {
            case PRIMEIRA_HABILITACAO ->
                    this == Categoria.ACC || this == Categoria.A || this == Categoria.B || this == Categoria.AB;
            case ADICAO_CATEGORIA -> switch (this) {
                case A, B, C, D, E -> true;
                default -> false;
            };
            case RENOVACAO, RECICLAGEM -> true;
            default -> false;
        };
    }
}
