package me.youngsil;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CouplemanProperties.class)
public class CouplemanConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Coupleman coupleman(CouplemanProperties properties) {
        Coupleman coupleman = new Coupleman();
        coupleman.setName(properties.getName());
        coupleman.setHowLong(properties.getHowLong());

        return coupleman;
    }
}
