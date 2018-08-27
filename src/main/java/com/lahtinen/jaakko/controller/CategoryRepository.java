package com.lahtinen.jaakko.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lahtinen.jaakko.data.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
