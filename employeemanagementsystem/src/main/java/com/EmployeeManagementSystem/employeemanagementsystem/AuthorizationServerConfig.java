package com.EmployeeManagementSystem.employeemanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.EmployeeManagementSystem.employeemanagementsystem.Service.AuthuserService;


//@Configuration
//@EnableAuthorizationServer
//@Order(5)
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//	
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    
//    @Autowired
//    private TokenStore tokenStore;
//    
//    @Autowired
//    private AuthuserService userService;
//    
//    
//   
//	
//	  @Bean 
//	  public PasswordEncoder passwordEncoder() { 
//	  
//		  return new BCryptPasswordEncoder(); 
//		  
//	  }
//	 
//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory().withClient("client")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .scopes("read", "write").autoApprove(true).secret(passwordEncoder().encode("password"))
//                .accessTokenValiditySeconds(3600);
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore);
//        endpoints.userDetailsService(userService);
//        
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//		 oauthServer.checkTokenAccess("isAuthenticated()"); 
// 
//		
//    }
//
//   
//}


@Configuration
@EnableAuthorizationServer
@Order(5)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final AuthuserService userService;
    private final TokenStore tokenStore;

    // Use constructor injection for these dependencies to avoid circular dependency issues
    @Autowired
    public AuthorizationServerConfig(AuthenticationManager authenticationManager, 
                                     AuthuserService userService, 
                                     @Lazy TokenStore tokenStore) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenStore = tokenStore;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenStore tokenStore() {
        // In-memory token store (can switch to JdbcTokenStore if needed)
        return new InMemoryTokenStore();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
               .withClient("client")
               .secret(passwordEncoder().encode("password"))
               .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
               .scopes("read", "write")
               .autoApprove(true)
               .accessTokenValiditySeconds(3600);  // 1 hour validity
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                 .tokenStore(tokenStore)  // Use the tokenStore bean
                 .userDetailsService(userService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                   .checkTokenAccess("isAuthenticated()")
                   .passwordEncoder(passwordEncoder());
    }
}
