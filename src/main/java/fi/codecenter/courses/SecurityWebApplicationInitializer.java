/*
 * $Id$
 * Copyright (c) Codecenter Oy. All rights reserved.
 *
 * This software is the proprietary information of Codecenter Oy.
 * Use is subject to license terms.
 */
package fi.codecenter.courses;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * The superclass AbstractSecurityWebApplicationInitializer will ensure that
 * springSecurityFilterChain is properly registered.
 *
 * <p>In addition the superclass can create a Spring ApplicationContext for us,
 * if we are not already using Spring Framework. In that case you should pass
 * the class containing Spring Security Java configuration to the superclass
 * constructor.</p>
 */
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebApplicationInitializer() {
        // If we are not already using Spring Framework, we can pass the Spring
        // Security Java configuration class (and others, if necessary) to the
        // superclass which will use it to create an ApplicationContext.
        // super(SpringSecurityConfig.class);
    }
}
