package com.pcjunior.exerciciossb.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pcjunior.exerciciossb.model.entities.Produto;
import com.pcjunior.exerciciossb.model.repositories.ProdutoRepository;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
 
    // AUTOMATICAMENTE COLOCA O OBJETO DENTRO DE PRODUTOREPOSITORY
    @Autowired
    private ProdutoRepository produtoRepository;
    
    // PODE SIMPLIFICAR COM UMA FUNÇÃO PARA VÁRIOS MÉTODOS HTTP, DESDE QUE TENHA A LÓGICA COMPARTILHADA
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
    public @ResponseBody Produto novoProduto(@Valid Produto produto){        
        produtoRepository.save(produto);
        return produto;
    }

    // MÉTODO QUE NÃO PODE DEIXAR PARA TODOS OS USUÁRIOS ACESSAREM
    @GetMapping
    public Iterable<Produto> obterProdutos(){
        return produtoRepository.findAll();
    }

    // CONSULTAR POR NOME
    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome){
        //return produtoRepository.findByNomeContaining(parteNome);
        return produtoRepository.searchBynameLike(parteNome);
    }

    // CONSULTA PAGINADA
    @GetMapping(path = "/pagina/{nPagina}/{qtdPagina}")
    public Iterable<Produto> obterProdutosPaginado(@PathVariable int nPagina, @PathVariable int qtdPagina){
        Pageable page = PageRequest.of(nPagina, qtdPagina);
        return produtoRepository.findAll(page);
    }

    // CONSULTA POR ID
    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoId(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    // DELETAR POR ID
    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }

    // MÉTODO FOI SIMPLIFICADO, PUT E POST NO MESMO.
    // @PutMapping
    // public Produto alterarProduto(@Valid Produto produto){
    //     return produtoRepository.save(produto);
    // }
    
}
