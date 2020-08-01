package com.youngsil.msaaccountservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("example")
@Getter
@Setter
public class PropertyConfig {

    private String message;
}
