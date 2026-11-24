package com.example.markmanagement.exception;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<Map<String,Object>> notFound(ResourceNotFoundException ex){return response(HttpStatus.NOT_FOUND,ex.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){
   Map<String,String> errors=new LinkedHashMap<>(); ex.getBindingResult().getFieldErrors().forEach(e->errors.put(e.getField(),e.getDefaultMessage()));
   Map<String,Object> body=new LinkedHashMap<>(); body.put("status",400); body.put("error","Validation failed"); body.put("messages",errors); return ResponseEntity.badRequest().body(body);
 }
 @ExceptionHandler(IllegalArgumentException.class)
 public ResponseEntity<Map<String,Object>> badRequest(IllegalArgumentException ex){return response(HttpStatus.BAD_REQUEST,ex.getMessage());}
 @ExceptionHandler(Exception.class)
 public ResponseEntity<Map<String,Object>> general(Exception ex){return response(HttpStatus.INTERNAL_SERVER_ERROR,"An unexpected error occurred. Check the application console.");}
 private ResponseEntity<Map<String,Object>> response(HttpStatus status,String message){Map<String,Object> b=new LinkedHashMap<>();b.put("status",status.value());b.put("error",status.getReasonPhrase());b.put("message",message);return ResponseEntity.status(status).body(b);}
}
