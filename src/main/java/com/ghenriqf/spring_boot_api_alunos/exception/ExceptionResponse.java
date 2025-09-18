package com.ghenriqf.spring_boot_api_alunos.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String mensagem;
    private int status;
    private LocalDateTime timestamp;

    public ExceptionResponse(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }
}
