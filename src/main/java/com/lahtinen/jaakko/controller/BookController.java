package com.lahtinen.jaakko.controller;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lahtinen.jaakko.data.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexPage(Model model) {
		return "index";
	} 
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
		public String rootPage(Model model) {
			return "redirect:booklist";
		}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(Model model) {
		return "login";
	}
	
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories",crepository.findAll());
        return "addbook";
    }
    
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }     
    
    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editBook( @PathVariable ("id") Long bookId, Model model) {
    	Optional<Book> b = repository.findById(bookId);
    	model.addAttribute("book", b);
        return "editbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
    	System.out.println(book);
//     	if(repository.existsById(book.getId())) {
//    		System.out.println("It exists");
//    		Book existing = repository.getOne(book.getId());
//    		existing.setTitle(book.getTitle());
//    		existing.setAuthor(book.getAuthor());
//    		existing.setIsbn(book.getIsbn());
//    		existing.setYear(book.getYear());
//    		existing.setCategory(book.getCategory());
//    		repository.deleteById(book.getId());
//    		repository.save(existing);
//    	} else {
            repository.save(book);
    //	}
        return "redirect:booklist";
    }    
    
    @RequestMapping(value="/booklist")
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    @RequestMapping(value="/api/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookID) {
    return repository.findById(bookID);
    }
	
}