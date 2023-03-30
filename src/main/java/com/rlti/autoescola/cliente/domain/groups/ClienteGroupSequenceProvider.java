package com.rlti.autoescola.cliente.domain.groups;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.empresa.domain.groups.PessoaJuridica;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente> {

    @Override
    public List<Class<?>> getValidationGroups(Cliente entity) {
        List<Class<?>> groups = new ArrayList<>();

        /*
         * Informamos ao HibernateValidator para usar as validações default
         * definidas na classe Cliente.
         */
        groups.add(Cliente.class);

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
