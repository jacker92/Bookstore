package com.lahtinen.jaakko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lahtinen.jaakko.controller.BookRepository;
import com.lahtinen.jaakko.data.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		log.info("Saving couple of new books");
	repository.save(new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 2000, "1234-asdf", 25.23));
	repository.save(new Book("Tarina menneisyydesta", "Linda Nummelin", 2017, "1234-XXX", 14.90));
	log.info("Fetching all books");
	for(Book b : repository.findAll()) {
		log.info(b.toString());
	}
	};
	}
}
