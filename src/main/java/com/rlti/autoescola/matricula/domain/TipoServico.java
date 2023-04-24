package com.rlti.autoescola.matricula.domain;

import com.rlti.autoescola.servico.domain.Categoria;

public enum TipoServico {
    PRIMEIRA_HABILITACAO {
        @Override
        public boolean isValidCategoria(Categoria categoria) {
            return categoria == Categoria.ACC || categoria == Categoria.A || categoria == Categoria.B
                    || categoria == Categoria.AB;
        }
    },
    ADICAO_CATEGORIA {
        @Override
        public boolean isValidCategoria(Categoria categoria) {
            return switch (categoria) {
                case A, B, C, D, E -> true;
                default -> false;
            };
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
