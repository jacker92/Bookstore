package com.lahtinen.jaakko.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lahtinen.jaakko.data.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
