package com.rlti.autoescola.matricula.domain;

import com.rlti.autoescola.servico.domain.Categoria;

public enum TipoServico {
    PRIMEIRA_HABILITACAO, ADICAO_CATEGORIA, RENOVACAO, RECICLAGEM, REEXAME;

    public boolean isValidCategoria(Categoria categoria) {
        switch (this) {
            case PRIMEIRA_HABILITACAO:
                return categoria == Categoria.ACC || categoria == Categoria.A || categoria == Categoria.B || categoria == Categoria.AB;
            case ADICAO_CATEGORIA:
                switch (categoria) {
                    case A:
                    case B:
                        return true;
                    case C:
                        return this.isValidCategoria(Categoria.B);
                    case D:
                        return this.isValidCategoria(Categoria.B) || this.isValidCategoria(Categoria.C);
                    case E:
                        return this.isValidCategoria(Categoria.D);
                    default:
                        return false;
                }
            default:
                return true;
        }
    }
}
