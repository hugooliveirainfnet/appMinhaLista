package com.minhalista.appMinhaLista.model.repositories;

import com.minhalista.appMinhaLista.model.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
