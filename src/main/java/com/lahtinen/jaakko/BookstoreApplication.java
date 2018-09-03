package com.lahtinen.jaakko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lahtinen.jaakko.controller.BookRepository;
import com.lahtinen.jaakko.controller.CategoryRepository;
import com.lahtinen.jaakko.controller.UserRepository;
import com.lahtinen.jaakko.data.Book;
import com.lahtinen.jaakko.data.Category;
import com.lahtinen.jaakko.data.User;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			Category c1 = new Category("Pelottavat kirjat");
			Category c2 = new Category("Fantasia");
			Category c3 = new Category("Historia");
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			log.info("Saving couple of new books");
			repository.save(new Book("Harry Potter ja viisasten kivi", "J.K.Rowling", 2000, "1234-asdf", 25.23, c1));
			repository.save(new Book("The Fall of Gondolin", "J. R. R. Tolkien", 2018, "9780008302757", 20.00, c2));
			repository.save(new Book("Viiden meren kansa", "Risto Isomäki", 2018, "9789522649393", 25.50, c3));
			log.info("Fetching all books");
			for (Book b : repository.findAll()) {
				log.info(b.getCategory().getName());
			}

		};
	}
}
