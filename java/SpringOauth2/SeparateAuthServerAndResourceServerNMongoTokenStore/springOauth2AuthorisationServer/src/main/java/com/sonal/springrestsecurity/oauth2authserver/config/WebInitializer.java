package com.sonal.springrestsecurity.oauth2authserver.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.sonal.springrestsecurity.oauth2authserver.config.application.Oauth2AuthServerApplicationConfig;

public class WebInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Oauth2AuthServerApplicationConfig.class);
	}

}
