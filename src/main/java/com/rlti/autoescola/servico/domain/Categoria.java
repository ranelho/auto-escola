package com.rlti.autoescola.servico.domain;

import com.rlti.autoescola.matricula.domain.TipoServico;

public enum Categoria {
    ACC, A, B, C, D, E, AB;

    public boolean isValidTipoServico(TipoServico tipoServico) {
        switch (tipoServico) {
            case PRIMEIRA_HABILITACAO:
                return this == Categoria.ACC || this == Categoria.A || this == Categoria.B || this == Categoria.AB;
            case ADICAO_CATEGORIA:
                switch (this) {
                    case A:
                    case E:
                        return this == Categoria.ACC || this == Categoria.B || this == Categoria.C || this == Categoria.D || this == Categoria.E;
                    case B:
                        return this == Categoria.ACC || this == Categoria.B || this == Categoria.C || this == Categoria.E;
                    case C:
                        return this == Categoria.ACC || this == Categoria.B || this == Categoria.D || this == Categoria.E;
                    case D:
                        return this == Categoria.ACC || this == Categoria.B || this == Categoria.C || this == Categoria.D || this == Categoria.E;
                    default:
                        return false;
                }
            case RENOVACAO:
                return true;
            case RECICLAGEM:
                return true;
            default:
                return false;
        }
    }
}
