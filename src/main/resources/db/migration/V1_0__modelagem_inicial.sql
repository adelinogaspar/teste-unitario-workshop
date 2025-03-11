create table aluno (
    id varchar(32),
    nome varchar(100),
    constraint pk_aluno primary key (id)
);

create table habilidade (
    id  varchar(32),
    tipo varchar(50),
    descricao varchar(2000),
    constraint pk_habilidade primary key (id)
);

create table habilidades_aluno (
    id_aluno varchar(32),
    id_habilidade varchar(32),
    constraint pk_habilidades_aluno primary key (id_aluno, id_habilidade),
    constraint fk_aluno
        foreign key (id_aluno)
        references aluno (id),
    constraint fk_habilidade
        foreign key (id_habilidade)
        references habilidade (id)
);
