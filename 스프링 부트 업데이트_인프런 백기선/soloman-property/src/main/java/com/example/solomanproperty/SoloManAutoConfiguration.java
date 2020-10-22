package com.example.solomanproperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SoloManProperties.class)
public class SoloManAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SoloMan soloMan(SoloManProperties soloManProperties) {
        SoloMan soloMan = new SoloMan();
        soloMan.setName(soloManProperties.getName());
        return soloMan;
    }
}
