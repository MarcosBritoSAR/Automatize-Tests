package com.marcosbrito.compass.semana8.automatize_test.web;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
  // @Override
  // protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
  //     HttpStatus status, WebRequest request) {
  //   return super.handleMethodArgumentNotValid(ex, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
  // }

  // @ExceptionHandler(DataIntegrityViolationException.class)
  // private ResponseEntity<Object> handleConflict(DataIntegrityViolationException ex) {
  //   return ResponseEntity.status(HttpStatus.CONFLICT)
  //       .body(ex.getMessage());
  // }

  // @ExceptionHandler(EmptyResultDataAccessException.class)
  // private ResponseEntity<Object> handleBadRequest(EmptyResultDataAccessException exception) {
  //   return ResponseEntity.status(HttpStatus.NOT_FOUND)
  //       .body(exception.getMessage());
  // }
}
