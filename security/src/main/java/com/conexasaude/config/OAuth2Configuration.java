package com.conexasaude.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {
  private static final String CLIENT_ID = "imed-challenge";
  private static final String CLIENT_SECRET = "imed-challenge";
  private static final String PRIVATE_KEY = "jwt.pem";
  private static final String PUBLIC_KEY = "jwt.pem";

  @Autowired
  @Qualifier(value = "authenticationManager")
  private AuthenticationManager authenticationManager;

  @Bean
  public JwtAccessTokenConverter tokenEnhancer() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey(PRIVATE_KEY);
    converter.setVerifierKey(PUBLIC_KEY);
    return converter;
  }

  @Bean
  public JwtTokenStore tokenStore() {
    return new JwtTokenStore(tokenEnhancer());
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        .authenticationManager(authenticationManager)
        .tokenStore(tokenStore())
        .accessTokenConverter(tokenEnhancer());
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients
        .inMemory()
        .withClient(CLIENT_ID)
        .secret(CLIENT_SECRET)
        .scopes("ADMIN", "USER", "HEALTH_PROFESSIONAL")
        .authorizedGrantTypes("password", "refresh_token")
        .accessTokenValiditySeconds(20000)
        .refreshTokenValiditySeconds(20000);
  }
}
