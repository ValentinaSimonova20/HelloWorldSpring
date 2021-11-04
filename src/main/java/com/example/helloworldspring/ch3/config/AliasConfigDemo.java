package com.example.helloworldspring.ch3.config;

import com.example.helloworldspring.ch3.annotated.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class AliasConfigDemo {

    @Configuration
    public static class AliasBeanConfig {
        @Bean(name = {"johnMayer", "john", "jonathan", "johnny"})
        public Singer singer()  {
            return new Singer("s");
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AliasBeanConfig.class);

        Map<String, Singer> beans =
                ctx.getBeansOfType(Singer.class);

        beans.forEach((key, value) -> System.out.println("id: " +
                        key + "\n aliases: "+ Arrays.toString(ctx.getAliases(key))
                ));
        ctx.close();
    }
}
