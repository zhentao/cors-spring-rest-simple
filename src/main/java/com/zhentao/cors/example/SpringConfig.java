package com.zhentao.cors.example;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan(basePackageClasses={EmployeeController.class})
@EnableWebMvc
public class SpringConfig {

    @Bean
    public RequestMappingHandlerMapping mapping() {
        return new RequestMappingHandlerMapping();
    }

//    @Bean
//    public MappingJackson2JsonView view() {
//        MappingJackson2JsonView view = new MappingJackson2JsonView();
//        //view.setContentType("text/plain");
//        return view;
//    }
//
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
