package com.springapp.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author asmolik
 */
@Configuration
@ComponentScan("com.springapp.mvc")
@Import({PersistenceContext.class})
public class ApplicationContext {
}
