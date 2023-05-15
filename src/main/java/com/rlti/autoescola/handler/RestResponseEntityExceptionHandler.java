package com.rlti.autoescola.handler;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException(APIException ex) {
		return ex.buildErrorResponseEntity();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException(Exception ex) {
		log.error("Exception: ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorApiResponse.builder().description("INTERNAL SERVER ERROR!")
						.message("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA!").build());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
		String mensagem = "O tamanho do arquivo enviado excede o limite permitido de 1 MB!";
		ErrorResponse erro = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), mensagem);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({AccessDeniedException.class, BadCredentialsException.class, ExpiredJwtException.class})
	public ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {
		String mensagem = "Erro ao realizar login!";
		if (ex instanceof AccessDeniedException) {
			mensagem = "Você não tem permissão para acessar este recurso!";
		} else if (ex instanceof BadCredentialsException) {
			mensagem = "Credenciais inválidas!";
		} else if (ex instanceof ExpiredJwtException) {
			mensagem = "Token de autenticação expirado!";
		}
		ErrorResponse erro = new ErrorResponse(HttpStatus.FORBIDDEN.value(), mensagem);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
	}
}
