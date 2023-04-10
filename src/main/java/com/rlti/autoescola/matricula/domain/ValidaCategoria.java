package com.rlti.autoescola.matricula.domain;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.servico.domain.Categoria;
import org.springframework.http.HttpStatus;

public class ValidaCategoria {
    public static boolean validaCombinacao(TipoServico tipoServico, Categoria categoria) {
        if (tipoServico.isValidCategoria(categoria)) {
            return true;
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST,"Operação não permitida");
        }
    }
}