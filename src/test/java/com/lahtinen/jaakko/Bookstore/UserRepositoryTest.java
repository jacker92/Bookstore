package com.lahtinen.jaakko.Bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lahtinen.jaakko.controller.UserRepository;
import com.lahtinen.jaakko.data.User;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
	User user = repository.findByUsername("admin");
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void createNewUserAndDeleteIt() {
		User user = new User("Jacker", "xxx", "admin");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
		assertThat(repository.findByUsername("Jacker")).isNotNull();
		repository.delete(user);
		assertThat(repository.findByUsername("Jacker")).isNull();
	}
}
