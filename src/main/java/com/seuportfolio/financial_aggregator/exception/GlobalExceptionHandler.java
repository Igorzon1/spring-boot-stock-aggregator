package com.seuportfolio.financial_aggregator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice // Avisa ao Spring: "Fique de olho em todos os Controllers e capture os erros"
public class GlobalExceptionHandler {

    // Dizemos: "Se alguém jogar um StockNotFoundException, execute este método!"
    @ExceptionHandler(feign.FeignException.class)
    public ResponseEntity<Object> handleFeignException(feign.FeignException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());

        // Se for erro 401 (Não Autorizado), avisamos sobre o Token
        if (ex.status() == 401) {
            body.put("status", HttpStatus.UNAUTHORIZED.value());
            body.put("error", "Não Autorizado");
            body.put("message", "Acesso negado na API externa. Verifique se o Token da Brapi está correto e ativo.");
            return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
        }

        // NOVO: Se for erro 404 (A Brapi avisou que a ação não existe lá)
        if (ex.status() == 404) {
            body.put("status", HttpStatus.NOT_FOUND.value());
            body.put("error", "Ação não encontrada");
            body.put("message", "A Brapi não encontrou nenhuma ação com este código.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }

        // Se for qualquer outro erro de fora
        body.put("status", HttpStatus.BAD_GATEWAY.value());
        body.put("error", "Erro de Integração");
        body.put("message", "A API externa da Brapi apresentou um problema. Tente novamente mais tarde.");

        return new ResponseEntity<>(body, HttpStatus.BAD_GATEWAY);
    }
}