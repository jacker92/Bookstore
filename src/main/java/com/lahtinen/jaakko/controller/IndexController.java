package com.lahtinen.jaakko.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController implements ErrorController {

	private static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
	public String error() {
		return "error";
	}
	@Override
	public String getErrorPath() {
		return PATH;
	}

}

