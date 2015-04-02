/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package fi.codecenter.courses;

import javax.sql.DataSource;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class defines Java configuration for Spring Security. We will need to
 * make sure that the configuration is processed by Spring.
 */
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * At minimum configuration must be provided for the authentication manager,
     * ie. how is the user authenticated and where does the user data come from.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("password")
            .roles("USER");
    }

    /**
     * An additional example adding bcrypt password hashing to the in-memory
     * user database. The password value is a hash of 'password'. As the seed is
     * a random value part of the hash, encoding the password again would give a
     * different result.
     *
     * @param auth
     * @throws Exception
     */
    private void exampleWithPasswordEncoding(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("user")
            .password(
                    "$2a$10$lCXaUM1pDyFu4xsp5LJz/uXrNz3zJDu.cyiAV./g3fCS1sg3UfVFS")
            .roles("USER");
    }

    /**
     * An additional example how to configure JDBC authentication with bcrypt
     * password hashing.
     *
     * @param auth
     * @throws Exception
     */
    private void exampleWithJdbcAuthenticationAndPasswordEncoding(
            AuthenticationManagerBuilder auth) throws Exception {
        DataSource ds = null;
        auth.jdbcAuthentication()
            .dataSource(ds)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
}
