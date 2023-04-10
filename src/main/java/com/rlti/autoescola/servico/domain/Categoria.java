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
                        return this == Categoria.A;
                    case E:
                        return this == Categoria.E;
                    case B:
                        return this == Categoria.B;
                    case C:
                        return this == Categoria.C;
                    case D:
                        return this == Categoria.D;
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
