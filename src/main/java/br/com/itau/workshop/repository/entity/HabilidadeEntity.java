package br.com.itau.workshop.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "habilidade")
@Getter
@Setter
public class HabilidadeEntity {
    @Id
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "descricao", length = 2000)
    private String descricao;

    @ManyToMany(mappedBy = "habilidades")
    private Set<AlunoEntity> alunos;
}
