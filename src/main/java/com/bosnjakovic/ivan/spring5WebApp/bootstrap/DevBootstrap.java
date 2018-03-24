package com.bosnjakovic.ivan.spring5WebApp.bootstrap;

import com.bosnjakovic.ivan.spring5WebApp.model.Author;
import com.bosnjakovic.ivan.spring5WebApp.model.Book;
import com.bosnjakovic.ivan.spring5WebApp.model.Publisher;
import com.bosnjakovic.ivan.spring5WebApp.repository.AuthorRepository;
import com.bosnjakovic.ivan.spring5WebApp.repository.BookRepository;
import com.bosnjakovic.ivan.spring5WebApp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Publisher
        Publisher publisher = new Publisher();
        publisher.setName("publisher one");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE","2345",publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

}
