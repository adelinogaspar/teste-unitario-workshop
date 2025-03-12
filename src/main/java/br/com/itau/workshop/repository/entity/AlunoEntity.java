package br.com.itau.workshop.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "aluno")
@Getter
@Setter
public class AlunoEntity {
    @Id
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "nome_real", length = 200)
    private String nomeReal;

    @Column(name = "nome_fantasia", length = 200)
    private String nomeFantasia;

    @Column(name = "forca")
    private Integer forca;

    @Column(name = "inteligencia")
    private Integer inteligencia;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @ManyToMany
    @JoinTable(
            name = "habilidades_aluno",
            joinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_habilidade", referencedColumnName = "id")
    )
    private Set<HabilidadeEntity> habilidades;
}
