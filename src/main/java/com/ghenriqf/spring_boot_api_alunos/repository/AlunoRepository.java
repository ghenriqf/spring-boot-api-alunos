package com.ghenriqf.spring_boot_api_alunos.repository;

import com.ghenriqf.spring_boot_api_alunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);

}
