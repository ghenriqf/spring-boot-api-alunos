package com.ghenriqf.spring_boot_api_alunos.service;

import com.ghenriqf.spring_boot_api_alunos.dto.AlunoRequestDTO;
import com.ghenriqf.spring_boot_api_alunos.dto.AlunoResponseDTO;
import com.ghenriqf.spring_boot_api_alunos.exception.RecursoDuplicadoException;
import com.ghenriqf.spring_boot_api_alunos.exception.RecursoNotFoundException;
import com.ghenriqf.spring_boot_api_alunos.mapper.AlunoMapper;
import com.ghenriqf.spring_boot_api_alunos.model.Aluno;
import com.ghenriqf.spring_boot_api_alunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }
    public AlunoResponseDTO buscarAluno(UUID id) {
        return alunoRepository
                .findById(id)
                .map(aluno -> alunoMapper.toResponse(aluno))
                .orElseThrow(() -> new RecursoNotFoundException(id));
    }

    public AlunoResponseDTO criarAluno(AlunoRequestDTO alunoRequestDTO) {
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

   public AlunoResponseDTO deletarAluno(UUID id) {
        return alunoRepository
                .findById(id)
                .map(aluno -> alunoMapper.toResponse(aluno))
                .orElseThrow(() -> new RecursoNotFoundException(id));
   }

   public List<AlunoResponseDTO> listarAlunos() {
        return alunoRepository
                .findAll()
                .stream()
                .map(aluno -> alunoMapper.toResponse(aluno))
                .collect(Collectors.toList());
   }

   public AlunoResponseDTO atualizarAluno(UUID id, AlunoRequestDTO alunoRequestDTO) {
        return alunoRepository
                .findById(id).map(aluno -> {
                    aluno.setCurso(alunoRequestDTO.curso());
                    aluno.setEmail(alunoRequestDTO.email());
                    return alunoMapper.toResponse(alunoRepository.save(aluno));
                })
                .orElseThrow(() -> new RecursoNotFoundException(id));
   }
}
