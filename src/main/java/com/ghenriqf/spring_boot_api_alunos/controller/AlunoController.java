package com.ghenriqf.spring_boot_api_alunos.controller;

import com.ghenriqf.spring_boot_api_alunos.dto.AlunoResponseDTO;
import com.ghenriqf.spring_boot_api_alunos.repository.AlunoRepository;
import com.ghenriqf.spring_boot_api_alunos.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscarAluno(@PathVariable UUID id) {
        return alunoService.buscarAluno(id);
    }
}
