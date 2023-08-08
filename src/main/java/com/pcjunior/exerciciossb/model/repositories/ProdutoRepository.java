package com.pcjunior.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pcjunior.exerciciossb.model.entities.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository <Produto, Integer> {

    // findByNomeContaining
    // findByNomeIsContaining
    // findByNomeContains


    // findByNomeStartsWith
    // findByNomeEndsWith

    // findByNomeNotContaining

    // POR CONVENÇÃO O SPRING JÁ IMPLEMENTA AUTOMATICAMENTE O MÉTODO
    public Iterable<Produto> findByNomeContaining(String parteNome);

    @Query ("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    public Iterable<Produto> searchBynameLike(@Param("nome") String nome);


    
}
