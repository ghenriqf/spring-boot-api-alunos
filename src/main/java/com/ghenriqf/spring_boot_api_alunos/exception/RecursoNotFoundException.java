package com.ghenriqf.spring_boot_api_alunos.exception;

import java.util.UUID;

public class RecursoNotFoundException extends RuntimeException{

    public RecursoNotFoundException (UUID id) {
        super("Recurso não encontrado com id: " + id);
    }
}
