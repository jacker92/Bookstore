package com.lahtinen.jaakko.Bookstore;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lahtinen.jaakko.controller.BookController;
import com.lahtinen.jaakko.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bController;
	
	@Autowired
	private UserController uController;
	
	@Test
	public void contextLoads() {
		assertThat(bController).isNotNull();
		assertThat(uController).isNotNull();
	}

}
