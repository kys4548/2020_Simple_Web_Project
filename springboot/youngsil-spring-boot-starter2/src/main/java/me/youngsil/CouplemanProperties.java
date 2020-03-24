package me.youngsil;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("coupleman")
public class CouplemanProperties {

    private String name;

    private int howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }
}
