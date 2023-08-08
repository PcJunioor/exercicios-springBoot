package com.pcjunior.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
    

    //@RequestMapping(method = RequestMethod.GET, path = "/ola") 
    // por padrão quando não tem o "method" "path" mapeia para qual url desejar

    @GetMapping(path = {"/ola", "/saudacao", "/"})
    public String ola(){
        return "Olá Spring Boot";
    }


    // PARA SIMULAR ERROS DE MAPEAMENTO AMBIGUO
    // @GetMapping(path = {"/saudacao"})

    // metodo diferente (POST) não gera erro de ambiguidade.
    // @PostMapping(path = "/saudacao")
    // public String saudacao(){
    //     return "Olá Spring Boot (POST)";
    // }
}
