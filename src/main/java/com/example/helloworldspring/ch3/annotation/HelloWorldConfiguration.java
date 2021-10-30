package com.example.helloworldspring.ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.example.helloworldspring.ch3.annotation"})
@Configuration
public class HelloWorldConfiguration {
}
