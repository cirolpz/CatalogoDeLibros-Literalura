package com.aluracurso.biblioteca.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatos {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> T obtenerDatos(String json, Class<T> clase){
        if (json == null || json.isEmpty()){
            System.out.println("El Json esta vacio");
            return null;
        }
        try {
            return mapper.readValue(json, clase);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}