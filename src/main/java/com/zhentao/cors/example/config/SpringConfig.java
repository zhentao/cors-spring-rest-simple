package com.zhentao.cors.example.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.zhentao.cors.example.controller.EmployeeController;
import com.zhentao.cors.example.exception.handler.RestResponseEntityExceptionHandler;

@Configuration
@ComponentScan(basePackageClasses = { EmployeeController.class, RestResponseEntityExceptionHandler.class })
@EnableWebMvc
@Import({ MetricsConfig.class })
public class SpringConfig {

    @Bean
    public RequestMappingHandlerMapping mapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter adapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.setMessageConverters(new ArrayList<HttpMessageConverter<?>>() {
            private static final long serialVersionUID = 3887357761520931161L;
            {
                add(messageConverter());
            }
        });

        return adapter;

    }

    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
}
