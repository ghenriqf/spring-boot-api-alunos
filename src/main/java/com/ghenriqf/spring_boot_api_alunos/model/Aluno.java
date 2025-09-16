package com.ghenriqf.spring_boot_api_alunos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
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

    public Aluno() {
    }

    public Aluno(String nome, LocalDate dataNascimento, String email, String cpf, String curso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
        this.curso = curso;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
