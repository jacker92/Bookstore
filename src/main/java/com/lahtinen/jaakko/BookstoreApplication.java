package com.lahtinen.jaakko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lahtinen.jaakko.controller.BookRepository;
import com.lahtinen.jaakko.controller.CategoryRepository;
import com.lahtinen.jaakko.data.Book;
import com.lahtinen.jaakko.data.Category;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
	return (args) -> {
		Category c1 = new Category("Pelottavat kirjat");
		Category c2 = new Category("Nuorten kirjat");
		crepository.save(c1);
		crepository.save(c2);
		log.info("Saving couple of new books");
	repository.save(new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 2000, "1234-asdf", 25.23, c1));
	repository.save(new Book("Tarina menneisyydesta", "Linda Nummelin", 2017, "1234-XXX", 14.90, c2));
	log.info("Fetching all books");
	for(Book b : repository.findAll()) {
		log.info(b.getCategory().getName());
	}

	
	};
	}
}
