/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package fi.codecenter.courses;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * If you're using Spring Framework and Java configuration in your application,
 * just add class SpringSecurityConfig to the array of your root configuration
 * classes.
 *
 * <p>In addition you also need to make sure that Spring Security has been
 * properly configured in the web application.</p>
 */
public class GlobalWebApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Return all global web application context configuration classes,
        // including the configuration for Spring Security.
        return new Class[] { SpringSecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
