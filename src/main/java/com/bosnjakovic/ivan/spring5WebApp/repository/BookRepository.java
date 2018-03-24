package com.bosnjakovic.ivan.spring5WebApp.repository;

import com.bosnjakovic.ivan.spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>{
}
