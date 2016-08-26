package io.khasang.sokol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    public void configurationGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
    }

    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
                .and()
                    .formLogin().defaultSuccessUrl("/index", false).loginPage("/login").permitAll()
                    .loginProcessingUrl("/j_spring_security_check")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password")
                    .failureUrl("/login?error=true")
                .and()
                    .requiresChannel()
                        .antMatchers("/login").requiresSecure()
                .and()
                    .csrf().disable();
    }
}
