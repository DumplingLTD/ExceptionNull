package com.jonthanpli;

import com.google.common.collect.ImmutableList;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class ExceptionNullApplication {
	private static final String DEBUG_PARAMETER = "-debug";

	private static Logger logger;
	private static boolean debug;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =
				SpringApplication.run(ExceptionNullApplication.class, args);
		logger = ctx.getBean(Logger.class);

		List<String> argList = ImmutableList.copyOf(args);
		if (argList.contains(DEBUG_PARAMETER)) {
			logger.log(Level.WARNING, "Debugging is enabled. If you see this message in prod, "
					+ "something's gone horribly wrong.");
			debug = true;
		}
	}

	@Bean
	public static Loader<?> loader() {
		return new ClasspathLoader();
	}

	@Bean
	public static PebbleEngine pebbleEngine() {
		PebbleEngine.Builder builder = new PebbleEngine.Builder()
				.loader(loader());

		// Debug only settings
		if (debug) {
			logger.log(Level.INFO, "Disabling Pebble Engine cache");
			builder.cacheActive(false);
		}

		return builder.build();
	}

	@Bean
	public static ViewResolver viewResolver() {
		PebbleViewResolver viewResolver = new PebbleViewResolver();
		viewResolver.setPrefix("templates/");
		viewResolver.setSuffix(".html");
		viewResolver.setPebbleEngine(pebbleEngine());

		return viewResolver;
	}

	@Bean
	public static Logger logger() {
		return Logger.getLogger(ExceptionNullApplication.class.getName());
	}
}
