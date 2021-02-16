/* Classe que substitui o Try cath no controlador, através da notation @ControllerAdvice */
/* A estrtura funciona da seguinte maneira: a camada de serviço envia a mensagem ao EntityNotFoundException. Essa classe identifica que é se 
 * trata de um erro e retorna ao controlador. O controlador identifica o erro através desta classe graças ao @ControllerAdvice e
 * faz a substituição do erro 500 para o o erro 400 (um erro mais claro para o usuário). A classe StandarError é responsável pela
   pela substituição do erro 500 para o erro 400
 */

package com.devsuperior.dsclient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dsclient.services.EntityNotFoundException;

@ControllerAdvice //Responsável por tratar a excessão que ocorre no controlador
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class) // diz que se no controlador ocorrer algum erro do tipo EntityNotFoundException, o erro será destina para o método abaixo
	public ResponseEntity<StandardError> clientNotFound(EntityNotFoundException e, HttpServletRequest request){ //o conteúdo da resposta vai ser um tipo StandardError
	   StandardError err =  new StandardError();
	   err.setTimeStamp(Instant.now());
	   err.setStatus(HttpStatus.NOT_FOUND.value());
	   err.setError("Resource not found !!");
	   err.setMessage(e.getMessage());
	   err.setPath(request.getRequestURI());
	   
	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	
	}
	
}
