package com.jonathanpli.exceptionnull.config;

import com.google.common.collect.ImmutableMap;
import com.jonathanpli.ExceptionNullApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles padding Pebble the offline mode flag if it's set
 */
@Configuration
public class ResourceConfig extends WebMvcConfigurerAdapter {
	private static final String OFFLINE_PATH = "/offline";
	private static final String RESOURCE_ATTRIBUTE_NAME = "resource";
	private static Map<String, String> offlineResourceCache;
	private static final Map<String, String> resources =
			new ImmutableMap.Builder<String, String>()
					.put("amazon", "https://s3-us-west-2.amazonaws.com/jpli-capstone")
					.put("jscloudflare", "https://cdnjs.cloudflare.com")
					.put("jquery", "https://code.jquery.com")
					.put("font", "https://www.fontify.me/wf/e6be3d2ca9f6e0ae85eeeaeb28724bd3")
					.put("fontawesome", "https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css")
					.build();

	@Bean
	public HandlerInterceptorAdapter offlineInterceptor() {

		return new HandlerInterceptorAdapter() {
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response,
								   Object handler, ModelAndView modelAndView) throws Exception {
				// Are we offline?
				if (ExceptionNullApplication.isOffline()) {
					// Build the offline map if it doesn't exist
					if (offlineResourceCache == null) {
						offlineResourceCache = new HashMap<>();
						for (String key : resources.keySet()) {
							offlineResourceCache.put(key, OFFLINE_PATH);
						}
						offlineResourceCache.put("font", "/offline/font/font.css");
						offlineResourceCache.put("fontawesome", "/offline/font/fontawesome.css");
					}
					// Give it to the templates
					modelAndView.addObject(RESOURCE_ATTRIBUTE_NAME, offlineResourceCache);
					return;
				}

				// Otherwise all is well, just give our map
				modelAndView.addObject(RESOURCE_ATTRIBUTE_NAME, resources);
			}
		};
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(offlineInterceptor());
	}
}
