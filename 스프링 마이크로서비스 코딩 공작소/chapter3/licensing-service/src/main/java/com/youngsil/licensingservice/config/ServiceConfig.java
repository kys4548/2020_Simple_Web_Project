package com.youngsil.licensingservice.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("example")
@Getter
@Setter
public class ServiceConfig {

    private String property;
}
