package com.jonthanpli;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class ExceptionNullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionNullApplication.class, args);
	}

	@Bean
	public Loader loader() {
		return new ClasspathLoader();
	}

	@Bean
	public PebbleEngine pebbleEngine() {
		return new PebbleEngine.Builder().loader(loader()).build();
	}

	@Bean
	public ViewResolver viewResolver() {
		PebbleViewResolver viewResolver = new PebbleViewResolver();
		viewResolver.setPrefix("templates/");
		viewResolver.setSuffix(".html");
		viewResolver.setPebbleEngine(pebbleEngine());
		return viewResolver;
	}
}
