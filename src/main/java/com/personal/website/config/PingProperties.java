package com.personal.website.config;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations = "classpath:ping.properties", ignoreUnknownFields = false, prefix = "ping")
public class PingProperties {

    @NotBlank
    private String urlOne;
    private String urlTwo;

    public String getUrlOne() {
        return urlOne;
    }

    public void setUrlOne(String urlOne) {
        this.urlOne = urlOne;
    }

    public String getUrlTwo() {
        return urlTwo;
    }

    public void setUrlTwo(String urlTwo) {
        this.urlTwo = urlTwo;
    }
}