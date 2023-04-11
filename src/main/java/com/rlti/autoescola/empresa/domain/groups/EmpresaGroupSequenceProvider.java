package com.rlti.autoescola.empresa.domain.groups;

import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.empresa.domain.Empresa;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class EmpresaGroupSequenceProvider implements DefaultGroupSequenceProvider<Empresa> {
    @Override
    public List<Class<?>> getValidationGroups(Empresa entity)  {
        List<Class<?>> groups = new ArrayList<>();

        /*
         * Informamos ao HibernateValidator para usar as validações default
         * definidas na classe Cliente.
         */
        groups.add(Empresa.class);

        if (entity != null) {
            /*
             * Aqui nós implementamos a lógica que determina o grupo de
             * validação a ser aplicado ao bean.
             */
            if ("FISICA".equalsIgnoreCase(String.valueOf(entity.getTipoPessoa()))) {
                groups.add(PessoaFisica.class);
            } else if ("JURIDICA".equalsIgnoreCase(String.valueOf(entity.getTipoPessoa()))) {
                groups.add(PessoaJuridica.class);
            }
        }
        return groups;
    }
}
