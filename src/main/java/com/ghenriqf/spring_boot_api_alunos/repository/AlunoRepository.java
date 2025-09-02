package com.ghenriqf.spring_boot_api_alunos.repository;

import com.ghenriqf.spring_boot_api_alunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
}
