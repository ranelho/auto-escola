package com.rlti.autoescola.matricula.domain;

import com.rlti.autoescola.servico.domain.Categoria;

public enum TipoServico {
    PRIMEIRA_HABILITACAO {
        @Override
        public boolean isValidCategoria(Categoria categoria) {
            return categoria == Categoria.ACC || categoria == Categoria.A || categoria == Categoria.B || categoria == Categoria.AB;
        }
    },
    ADICAO_CATEGORIA {
        @Override
        public boolean isValidCategoria(Categoria categoria) {
            switch (categoria) {
                case A:
                case E:
                    return categoria == Categoria.ACC || categoria == Categoria.B || categoria == Categoria.C || categoria == Categoria.D || categoria == Categoria.E;
                case B:
                    return categoria == Categoria.ACC || categoria == Categoria.B || categoria == Categoria.C || categoria == Categoria.E;
                case C:
                    return categoria == Categoria.B || categoria == Categoria.D || categoria == Categoria.E;
                case D:
                    return categoria == Categoria.B || categoria == Categoria.C || categoria == Categoria.D || categoria == Categoria.E;
                default:
                    return false;
            }
        }
    },
    RENOVACAO {
        @Override
        public boolean isValidCategoria(Categoria categoria) {
            return true;
        }
    },
    RECICLAGEM {
        @Override
        public boolean isValidCategoria(Categoria categoria) {
            return true;
        }
    };

    public abstract boolean isValidCategoria(Categoria categoria);
}
