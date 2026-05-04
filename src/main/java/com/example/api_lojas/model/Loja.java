package com.example.api_lojas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lojas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cnpj", nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(name = "telefone", nullable = true, length = 20)
    private String telefone;

    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;

    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @Column(name = "ativa", nullable = false)
    private Boolean ativa = true;
}
