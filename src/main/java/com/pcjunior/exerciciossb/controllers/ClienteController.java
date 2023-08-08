package com.pcjunior.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcjunior.exerciciossb.model.entities.Cliente;


@RestController
//fica como uma base para os outros links ex: \clientes\qualquer
@RequestMapping("/clientes")
public class ClienteController {
    
    @GetMapping("/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28, "Pedro", "123.456.789-00");
    }

    // entre {} pra dizer que é variável
    @GetMapping("/{id}")
    // @pathVariable para mapear a variável
    public Cliente obterClienteId1(@PathVariable int id){
        return new Cliente(id, "Maria", "987.654.321-00");
    }

    @GetMapping
    // @requestparam serve para definir o parametro que sera recebido pela url
    public Cliente obterClienteId2(@RequestParam(name = "id", defaultValue = "1") int id){
        return new Cliente(id, "Paulo Cesar", "123.321.456-00");    
    }
}
