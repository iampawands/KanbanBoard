package com.pawan.kanbanboard.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;

@Service
public class MapErrorValidationService {
    public ResponseEntity<?> getErrorMap(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,String> errorMap = new HashMap<>();
            for(FieldError fieldError : bindingResult.getFieldErrors()){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<HashMap<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
