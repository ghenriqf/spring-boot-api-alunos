package com.ghenriqf.spring_boot_api_alunos.exception;

public class RecursoDuplicadoException extends RuntimeException{

    public RecursoDuplicadoException (String mensagem) {
        super(mensagem);
    }
}
