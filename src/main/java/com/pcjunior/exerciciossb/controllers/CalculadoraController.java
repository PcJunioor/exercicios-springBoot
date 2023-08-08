package com.pcjunior.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// /calculadora/somar/10/20 redeber 2 numeros e retornar como resposta

// /calculadora/subtrair?a=10&b=20
@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    
    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b){
        return a + b;
        
    }
        
    @GetMapping("/subtrair")
    public int subtrair(@RequestParam (name = "a") int a, @RequestParam (name = "b") int b) {
         return b - a;
    }

}
