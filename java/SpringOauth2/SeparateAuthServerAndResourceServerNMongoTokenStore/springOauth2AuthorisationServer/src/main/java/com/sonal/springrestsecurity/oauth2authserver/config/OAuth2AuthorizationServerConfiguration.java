package com.sonal.springrestsecurity.oauth2authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.sonal.springrestsecurity.oauth2authserver.service.ApiUserDetailsLookupService;

@EnableAuthorizationServer
@Configuration
public class OAuth2AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final String RESOURCE_ID = "restservice";

    private TokenStore tokenStore = new InMemoryTokenStore();

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	private ApiUserDetailsLookupService userDetailsService;

	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer authServerSecurityConfig) throws Exception {
	    authServerSecurityConfig.tokenKeyAccess("isAuthenticated() && hasAuthority('accessToClientTokenStoreAuthority')")
	    	    .checkTokenAccess("isAuthenticated() && hasAuthority('accessToClientTokenStoreAuthority')");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer authServerEndPointsConfig) throws Exception {
	    authServerEndPointsConfig.tokenStore(this.tokenStore)
	    	     .authenticationManager(this.authenticationManager)
	    	     .userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

	    clients.inMemory().withClient("ResourceServiceNode")
	    		      .secret("12345")
	    		      .authorities("accessToClientTokenStoreAuthority")
	    		      .and()
	    		      .withClient("trustedAppClient")
	    		      .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit", "redirect")
	    		      .authorities("USER")
	    		      .scopes("read", "write", "trust")
	    		      .resourceIds(RESOURCE_ID)
	    		      .secret("123")
	    		      .accessTokenValiditySeconds(120)
	    		      .refreshTokenValiditySeconds(2040);

	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
	    DefaultTokenServices tokenServices = new DefaultTokenServices();
	    tokenServices.setSupportRefreshToken(true);
	    tokenServices.setTokenStore(this.tokenStore);
	    return tokenServices;
	}
   

}
