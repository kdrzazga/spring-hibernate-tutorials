package org.kd.spring.springsecurity;

import org.kd.spring.springsecurity.config.SecSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SecSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];//TODO: fill in
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];//TODO: fill in
    }
}
