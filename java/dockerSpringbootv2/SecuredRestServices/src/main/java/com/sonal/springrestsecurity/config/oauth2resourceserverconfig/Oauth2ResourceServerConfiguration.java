package com.sonal.springrestsecurity.config.oauth2resourceserverconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class Oauth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "restservice";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
	resources.resourceId(RESOURCE_ID);
	resources.tokenServices(remoteTokenServices());
    }
    
    

    @Override
    public void configure(HttpSecurity http) throws Exception {

	 http.authorizeRequests()
	    	.antMatchers("/SecuredControllerB").hasRole("ADMIN")
	    	.antMatchers("/SecuredControllerA").authenticated();
	
    }
    
    @Bean
    public ResourceServerTokenServices remoteTokenServices(){
	RemoteTokenServices remoteTokenService = new RemoteTokenServices();
	remoteTokenService.setCheckTokenEndpointUrl("http://localhost:8081/oauth/check_token");
	remoteTokenService.setClientId("ResourceServiceNode");
	remoteTokenService.setClientSecret("12345");
	return remoteTokenService;
    }

}
