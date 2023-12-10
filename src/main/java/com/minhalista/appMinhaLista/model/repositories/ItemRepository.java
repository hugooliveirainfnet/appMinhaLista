package com.minhalista.appMinhaLista.model.repositories;

import com.minhalista.appMinhaLista.model.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
