package com.jonathanpli;

import com.google.common.collect.ImmutableList;
import com.jonathanpli.exceptionnull.controller.helpers.PebbleExtension;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class ExceptionNullApplication extends WebMvcConfigurerAdapter {
	private static final String DEBUG_PARAMETER = "-debug";

	private static Logger logger = Logger.getLogger(ExceptionNullApplication.class.getName());
	private static boolean debug;

	private static final String OFFLINE_PARAMETER = "-offline";
	private static final String OFFLINE_PATH_PARAMETER = "-offlinePath";
	private static boolean isOffline;
	private static String offlineFolderLocation;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (isOffline) {
			logger.log(Level.WARNING, "****** STARTING IN OFFLINE MODE *******");
			logger.log(Level.WARNING, "Serving static files on '/offline' from '"
					+ offlineFolderLocation + "'");
			registry.addResourceHandler("/offline/**")
					.addResourceLocations("file:" + offlineFolderLocation);
		}
	}

	public static void main(String[] args) {
		// Parse args
		List<String> argList = ImmutableList.copyOf(args);

		// Debug mode?
		if (argList.contains(DEBUG_PARAMETER)) {
			logger.log(Level.WARNING, "Debugging is enabled. If you see this message in prod, "
					+ "something's gone horribly wrong.");
			debug = true;
		}

		// Offline mode?
		if (argList.contains(OFFLINE_PARAMETER)) {
			if (!argList.contains(OFFLINE_PATH_PARAMETER)) {
				throw new RuntimeException("-offline parameter passed, but no path was given via -offlinePath");
			}
			int i = argList.indexOf(OFFLINE_PATH_PARAMETER);
			offlineFolderLocation = argList.get(i + 1);
			isOffline = true;
		}

		// Start the server!
		ConfigurableApplicationContext ctx =
				SpringApplication.run(ExceptionNullApplication.class, args);
	}

	@Bean
	public static Loader<?> loader() {
		return new ClasspathLoader();
	}

	@Bean
	public static PebbleEngine pebbleEngine() {
		PebbleEngine.Builder builder = new PebbleEngine.Builder()
				.extension(new PebbleExtension())
				.loader(loader());

//		if (debug) {
			logger.log(Level.INFO, "Disabling Pebble Engine cache");
			builder.cacheActive(false);
//		}

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
		return logger;
	}

	/**
	 * @return Whether or not the server is running in offline mode
	 */
	public static boolean isOffline() {
		return isOffline;
	}
}
