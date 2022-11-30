// package com.imedicina.auth;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
// import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

// @Configuration
// @EnableWebSecurity
// public class BasicConfiguration extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .cors()
//                 .and()
//                     .authorizeRequests()
//                         .antMatchers("/api/patient/*")
//                             .hasAuthority("PATIENT")
//                         .antMatchers("/api/professional/*")
//                             .hasAnyAuthority("PROFESSIONAL")
//                     .anyRequest()
//                         .authenticated()
//                 .and()
//                     .oauth2ResourceServer()
//                         .jwt()
//                             .jwtAuthenticationConverter(getJwtAuthenticantionCoverter());

//     }

//     JwtAuthenticationConverter getJwtAuthenticantionCoverter() {
//         JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
//         converter.setAuthoritiesClaimName("authorities");
//         converter.setAuthorityPrefix("");
//         JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
//         authenticationConverter.setJwtGrantedAuthoritiesConverter(converter);
//         return authenticationConverter;
//     }
    
// }
