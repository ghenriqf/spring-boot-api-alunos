package com.ghenriqf.spring_boot_api_alunos.service;

import com.ghenriqf.spring_boot_api_alunos.dto.AlunoRequestDTO;
import com.ghenriqf.spring_boot_api_alunos.dto.AlunoResponseDTO;
import com.ghenriqf.spring_boot_api_alunos.exception.RecursoDuplicadoException;
import com.ghenriqf.spring_boot_api_alunos.mapper.AlunoMapper;
import com.ghenriqf.spring_boot_api_alunos.model.Aluno;
import com.ghenriqf.spring_boot_api_alunos.repository.AlunoRepository;

public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoResponseDTO salvarAluno(AlunoRequestDTO alunoRequestDTO) {
        if (alunoRepository.existsByEmail(alunoRequestDTO.email())) {
            throw new RecursoDuplicadoException("email já registrado: " + alunoRequestDTO.email());
        }
        if (alunoRepository.existsByCpf(alunoRequestDTO.cpf())) {
            throw new RecursoDuplicadoException("cpf já registrado: " + alunoRequestDTO.cpf());
        }
        Aluno aluno = alunoMapper.toEntity(alunoRequestDTO);
        Aluno alunoSalvo = alunoRepository.save(aluno);

        return alunoMapper.toResponse(alunoSalvo);
   }

}
