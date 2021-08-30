package com.study.springboot.ex25.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/ex25/").permitAll()
                .antMatchers("/ex25/css/**", "/ex25/js/**", "/ex25/img/**").permitAll()
                .antMatchers("/ex25/guest/**").permitAll()
                .antMatchers("/ex25/member/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/ex25/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();
 
        http.formLogin()
                .permitAll();
 
        http.logout()
                .permitAll();
    }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
            .and()
            .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
            // ROLE_ADMIN 에서 ROLE_는 자동으로 붙는다.
    }
    
    // passwordEncoder() 추가
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    
}
