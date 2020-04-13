package com.viniciuspessoni.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@EnableWebSecurity
class ConfiguracaoSegura : WebSecurityConfigurerAdapter() {


    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth
            .inMemoryAuthentication()
            .withUser("aluno").password("{noop}senha").roles("USER")
    }


    /**
     * Segurança dos endpoints com autenticação básica
     */
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.GET, "/risco/**").hasRole("USER")
            .and()
            .csrf().disable()
            .formLogin().disable()
    }

}