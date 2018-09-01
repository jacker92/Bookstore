package com.lahtinen.jaakko.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lahtinen.jaakko.controller.CategoryRepository;
import com.lahtinen.jaakko.controller.UserRepository;
import com.lahtinen.jaakko.data.Category;
import com.lahtinen.jaakko.data.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByIDShouldReturnCategory() {
	Category c = new Category("TestCategory");
	repository.save(c);
	assertThat(repository.getOne(c.getCategoryid())).isNotNull();
	}
	
	@Test
	public void deleteAllAndReturnCountOfZero() {
		repository.deleteAll();
		assertThat(repository.count()).isZero();
	}
	
	
}
