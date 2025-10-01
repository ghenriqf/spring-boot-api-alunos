package com.ghenriqf.spring_boot_api_alunos.controller;

import com.ghenriqf.spring_boot_api_alunos.dto.AlunoRequestDTO;
import com.ghenriqf.spring_boot_api_alunos.dto.AlunoResponseDTO;
import com.ghenriqf.spring_boot_api_alunos.service.AlunoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoResponseDTO criarAluno(@RequestBody @Valid @NotNull AlunoRequestDTO aluno) {
        return alunoService.criarAluno(aluno);
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscarAluno(@PathVariable UUID id) {
        return alunoService.buscarAluno(id);
    }

    @DeleteMapping("/{id}")
    public AlunoResponseDTO deletarAluno(@PathVariable UUID id) {
        return alunoService.deletarAluno(id);
    }

    @GetMapping
    public List<AlunoResponseDTO> listarAlunos() {
        return alunoService.listarAlunos();
    }
}
