package com.lahtinen.jaakko.Bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import com.lahtinen.jaakko.controller.BookRepository;
import com.lahtinen.jaakko.data.Book;
import com.lahtinen.jaakko.data.Category;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Test
	public void findByAuthorShouldReturnBook() {
		List<Book> books = repository.findByAuthor("J.K.Rowling");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor().equals("J.K.Rowling"));
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Testikirja", "Jaakko Lahtinen", 1992, "1234-1234", 20.41, new Category("Pelottavat"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void nullBookThrowsException() {
		Book b = null;
		repository.save(b);
	}

}
