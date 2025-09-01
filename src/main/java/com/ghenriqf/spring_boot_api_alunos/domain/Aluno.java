package com.ghenriqf.spring_boot_api_alunos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private UUID id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "O CPF é inválido")
    @Column(name = "cpf")
    private String cpf;

    @NotBlank(message = "O curso é obrigatório")
    @Column(name = "curso")
    private String curso;

}
