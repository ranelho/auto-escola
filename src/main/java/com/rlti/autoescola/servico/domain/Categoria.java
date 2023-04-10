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
                    case B:
                        return true;
                    case C:
                        return tipoServico.isValidCategoria(Categoria.B);
                    case D:
                        return tipoServico.isValidCategoria(Categoria.B) || tipoServico.isValidCategoria(Categoria.C);
                    case E:
                        return tipoServico.isValidCategoria(Categoria.D);
                    default:
                        return false;
                }
            default:
                return true;
        }
    }
}
