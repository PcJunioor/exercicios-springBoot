package com.pcjunior.exerciciossb.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String nome;
    
    @Min(0)
    private BigDecimal preco;

    @Min(0)
    @Max(1)
    private BigDecimal desconto;


    public Produto(){

    }
    
        
    public Produto(int id) {
        this.id = id;
    }


    public Produto(String nome, BigDecimal preco, BigDecimal desconto) {
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }


    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public BigDecimal getPreco() {
        return preco;
    }


    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }


    public BigDecimal getDesconto() {
        return desconto;
    }


    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    


  

    

    
}
