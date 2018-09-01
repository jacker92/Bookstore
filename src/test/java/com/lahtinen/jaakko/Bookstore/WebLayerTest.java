package com.lahtinen.jaakko.Bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;

import com.lahtinen.jaakko.controller.BookController;
import com.lahtinen.jaakko.controller.BookRepository;
import com.lahtinen.jaakko.controller.CategoryRepository;
import com.lahtinen.jaakko.controller.UserController;
import com.lahtinen.jaakko.controller.UserRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookController controller;
	
	@MockBean
	private UserController ucontroller;
	
	@MockBean
	private BookRepository br;
	
	@MockBean
	private UserRepository ur;
	
	@MockBean
	private CategoryRepository cr;
	
	@Test
	public void testRootStatus() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is(401));
	}
	
	@Test
	public void testLogin() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}

}
