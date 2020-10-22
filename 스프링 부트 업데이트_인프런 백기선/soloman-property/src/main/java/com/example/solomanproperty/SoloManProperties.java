package com.example.solomanproperty;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("soloman")
public class SoloManProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
