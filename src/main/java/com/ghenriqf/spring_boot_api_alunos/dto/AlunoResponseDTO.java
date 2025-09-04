package com.ghenriqf.spring_boot_api_alunos.dto;

import java.time.LocalDate;
import java.util.UUID;

public record AlunoResponseDTO(
        UUID id,
        String nome,
        LocalDate dataNascimento,
        String email,
        String cpf,
        String curso
) {}
