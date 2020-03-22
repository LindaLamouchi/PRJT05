package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// create a user
	 auth.inMemoryAuthentication()
	 .withUser("user")
	 .password("rock")
	 .roles("USER")
	 .and()
	 .withUser("admin")
	 .password("roll")
	 .roles("ADMIN");
	 //time for hash
	
}
 @Bean
 public PasswordEncoder getPasswordEncoder() {
	 //duplicated but works
	 return NoOpPasswordEncoder.getInstance();
 }
 @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //give authorization
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	} 
 
}
