/*
 * package com.cashrich.NewRestfulApi;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.core.userdetails.UserDetailsService;
 * 
 * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * import org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * import org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig {
 * 
 * private final UserDetailsService userDetailsService;
 * 
 * public SecurityConfig(UserDetailsService userDetailsService) {
 * this.userDetailsService = userDetailsService; }
 * 
 * @SuppressWarnings({ "deprecation", "removal" })
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { http.csrf().disable() .authorizeRequests()
 * .requestMatchers("/signup", "/login").permitAll()
 * .anyRequest().authenticated() .and()
 * .formLogin().loginPage("/login").permitAll() .and() .logout().permitAll();
 * return http.build(); }
 * 
 * 
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Exception {
 * auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()
 * ); } }
 */