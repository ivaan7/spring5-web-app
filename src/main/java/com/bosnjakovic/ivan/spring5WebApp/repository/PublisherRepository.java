package com.bosnjakovic.ivan.spring5WebApp.repository;

import com.bosnjakovic.ivan.spring5WebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long>{
}
