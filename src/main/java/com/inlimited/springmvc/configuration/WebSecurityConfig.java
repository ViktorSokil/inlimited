package com.inlimited.springmvc.configuration;

import com.inlimited.springmvc.entity.User;
import com.inlimited.springmvc.service.api.IAuthenticationService;
import com.inlimited.springmvc.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.inlimited.springmvc")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private IAuthenticationService authenticationService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("admin@gmail.com").password("pass").roles("ADMIN");*/

        InMemoryUserDetailsManagerConfigurer configurer = auth.inMemoryAuthentication();

        for(User user : authenticationService.getAdmins()) {
            configurer.withUser(user.getUserEmail())
                    .password(user.getPassword())
                    .roles(user.getRole());
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/*").authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login").permitAll()
                .and()
                .httpBasic();
    }


}
