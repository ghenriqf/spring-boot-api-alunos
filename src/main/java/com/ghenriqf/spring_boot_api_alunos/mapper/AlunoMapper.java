package com.ghenriqf.spring_boot_api_alunos.mapper;

import com.ghenriqf.spring_boot_api_alunos.dto.AlunoRequestDTO;
import com.ghenriqf.spring_boot_api_alunos.dto.AlunoResponseDTO;
import com.ghenriqf.spring_boot_api_alunos.model.Aluno;

public class AlunoMapper {

    public Aluno toEntity(AlunoRequestDTO dto) {
        return new Aluno(
                dto.nome(),
                dto.dataNascimento(),
                dto.email(),
                dto.cpf(),
                dto.curso());
    }

    public AlunoResponseDTO toResponse(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getEmail(),
                aluno.getCpf(),
                aluno.getCurso());
    }
}