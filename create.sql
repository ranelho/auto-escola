
    create table agenda (
       id_agenda bigserial not null,
        data date,
        horario_aula varchar(255),
        tipo_aula varchar(255),
        instrutor_id uuid,
        matricula_id uuid,
        veiculo_id uuid,
        primary key (id_agenda)
    );

    create table cliente (
       id_cliente uuid not null,
        cpf varchar(255),
        data_cadastro date,
        data_nascimento date,
        estado_civil varchar(255),
        full_name varchar(255) not null,
        nacionalidade varchar(255),
        naturalidade varchar(255),
        primary key (id_cliente)
    );

    create table contato (
       id_contato uuid not null,
        cep varchar(255),
        cidade varchar(255),
        email varchar(255),
        endereco varchar(255),
        telefone varchar(255),
        uf varchar(255),
        cliente_id uuid,
        primary key (id_contato)
    );

    create table empresa (
       id_empresa uuid not null,
        aceita_termos boolean not null,
        area_atuacao varchar(255),
        cnpj varchar(255),
        data_abertura date not null,
        email varchar(255),
        endereco_comercial varchar(255) not null,
        inscricao_municipal varchar(255),
        nome_administrador varchar(255),
        nome_fantasia varchar(255),
        razao_social varchar(255),
        telefone varchar(255),
        primary key (id_empresa)
    );

    create table exame (
       id_exame bigserial not null,
        data_exame date,
        observacao varchar(255),
        resultado varchar(255),
        tipo_exame varchar(255),
        cliente_id uuid,
        primary key (id_exame)
    );

    create table imagem (
       id bigserial not null,
        dados bytea,
        cliente_id uuid,
        primary key (id)
    );

    create table instrutor (
       id_instrutor uuid not null,
        aulas smallint array,
        categoria varchar(255),
        cnh varchar(11),
        cpf varchar(14),
        nome_completo varchar(255),
        status varchar(255),
        validade_cnh date,
        primary key (id_instrutor)
    );

    create table laudo (
       id_laudo bigserial not null,
        data_emissao date,
        renach varchar(255),
        validade date,
        matricula_id uuid,
        primary key (id_laudo)
    );

    create table manutencao (
       id_manutencao bigserial not null,
        data_manutencao date,
        descricao varchar(255),
        tipo_manutencao varchar(255),
        valor_manutencao numeric(38,2),
        veiculo_id uuid,
        primary key (id_manutencao)
    );

    create table matricula (
       id_matricula uuid not null,
        data_matricula date,
        desconto integer not null,
        observacao varchar(255),
        quantidade_parcelas integer not null check (quantidade_parcelas<=12 AND quantidade_parcelas>=1),
        status varchar(255),
        tipo_pagamento varchar(255),
        tipo_servico varchar(255),
        valor_entrada numeric(38,2),
        valor_final numeric(38,2),
        cliente_id uuid,
        servico_id_servico uuid,
        primary key (id_matricula)
    );

    create table orcamento (
       id_orcamento bigserial not null,
        data_orcamento date,
        desconto integer not null,
        observacao varchar(255),
        quantidade_parcelas integer not null check (quantidade_parcelas<=12 AND quantidade_parcelas>=1),
        tipo_pagamento varchar(255),
        tipo_servico varchar(255),
        validade date,
        valor_entrada numeric(38,2),
        valor_final numeric(38,2),
        cliente_id_cliente uuid,
        servico_id_servico uuid,
        primary key (id_orcamento)
    );

    create table pagamento (
       id_pagamento bigserial not null,
        data_pagamento date,
        tipo_pagamento varchar(255),
        valor_pago numeric(38,2),
        matricula_id uuid,
        primary key (id_pagamento)
    );

    create table servico (
       id_servico uuid not null,
        categoria varchar(255),
        quantidade_horas_aula integer,
        status varchar(255),
        valor_servico numeric(38,2),
        primary key (id_servico)
    );

    create table veiculo (
       id_veiculo uuid not null,
        ano varchar(255) not null,
        marca varchar(255),
        modelo varchar(255),
        placa varchar(255),
        status varchar(255),
        tipo varchar(255),
        primary key (id_veiculo)
    );

    alter table if exists cliente 
       add constraint UK_r1u8010d60num5vc8fp0q1j2a unique (cpf);

    alter table if exists empresa 
       add constraint UK_74xhe5obsc7li6x4q5wi75pd5 unique (cnpj);

    alter table if exists empresa 
       add constraint UK_nfu2qgep9eyw4f7jpxoxix8ci unique (email);

    alter table if exists instrutor 
       add constraint UK_43ns1sw4v3nwhitmgxktycpgx unique (cnh);

    alter table if exists instrutor 
       add constraint UK_ssck8n5yw85eypxtcs8f6m9ss unique (cpf);

    alter table if exists laudo 
       add constraint UK_24gd3maohrye4ngxmn5mf3nyk unique (renach);

    alter table if exists servico 
       add constraint UK_6gbu43yajg3eg2wq5ss87who8 unique (categoria);

    alter table if exists veiculo 
       add constraint UK_luoyk9d8idgi0wif7bxtefsr5 unique (placa);

    alter table if exists agenda 
       add constraint FKg4bqan31d8p62hwx2orehotsw 
       foreign key (instrutor_id) 
       references instrutor;

    alter table if exists agenda 
       add constraint FKdtbdhfdy4r0l7eke57xes0squ 
       foreign key (matricula_id) 
       references matricula;

    alter table if exists agenda 
       add constraint FKetjuehrapq1xvhksgguum1l5l 
       foreign key (veiculo_id) 
       references veiculo;

    alter table if exists contato 
       add constraint FK1r20f8ialoyah673ovyow8js5 
       foreign key (cliente_id) 
       references cliente;

    alter table if exists exame 
       add constraint FKjdojmm0kod39pif34jfjl53yj 
       foreign key (cliente_id) 
       references matricula;

    alter table if exists imagem 
       add constraint FKc7ibiq6r9ky1adl1fx8yaxlwd 
       foreign key (cliente_id) 
       references cliente;

    alter table if exists laudo 
       add constraint FKptuykscribp5dmwpco5d1139m 
       foreign key (matricula_id) 
       references matricula;

    alter table if exists manutencao 
       add constraint FKm7fav74sh3y93kr8tp2fb4ay1 
       foreign key (veiculo_id) 
       references veiculo;

    alter table if exists matricula 
       add constraint FK79828bcp0vahbxj0inldc3vqm 
       foreign key (cliente_id) 
       references cliente;

    alter table if exists matricula 
       add constraint FKi12qcqkus5hv332dv39cc1yia 
       foreign key (servico_id_servico) 
       references servico;

    alter table if exists orcamento 
       add constraint FKm3byk25rqkopdhpqvmgvhjl8v 
       foreign key (cliente_id_cliente) 
       references cliente;

    alter table if exists orcamento 
       add constraint FKrwagpg2qdo8d8tcqh2yrfuall 
       foreign key (servico_id_servico) 
       references servico;

    alter table if exists pagamento 
       add constraint FKsojmwpagcpe2skun1vqpcq7bb 
       foreign key (matricula_id) 
       references matricula;
