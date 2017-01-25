package com.personal.website.config;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ConfigurationProperties(locations = "classpath:ping.properties", ignoreUnknownFields = false, prefix = "ping")
public class PingProperties {

    @NotBlank
    private String urls;

    @NotBlank
    private String interval;

    @NotBlank
    private String timeunit;

    @NotBlank
    private String initialdelay;

    public List<String> getUrlList() {
        List<String> urlList =new ArrayList<>();
        for (String url : urls.replaceAll("\\s","").split(",")) {
            urlList.add("http://"+url+"/");
        }
        return urlList;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public int getInterval() {
        return Integer.valueOf(interval);
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public void setTimeunit(String timeunit) {
        this.timeunit = timeunit;
    }

    public int getInitialdelay() {
        return Integer.valueOf(initialdelay);
    }

    public void setInitialdelay(String initialdelay) {
        this.initialdelay = initialdelay;
    }

    public TimeUnit getTimeUnit() {
        if("NANOSECONDS".equals(timeunit)) return TimeUnit.NANOSECONDS;
        else if("MICROSECONDS".equals(timeunit)) return TimeUnit.MICROSECONDS;
        else if("MILLISECONDS".equals(timeunit)) return TimeUnit.MILLISECONDS;
        else if("SECONDS".equals(timeunit)) return TimeUnit.SECONDS;
        else if("MINUTES".equals(timeunit)) return TimeUnit.MINUTES;
        else if("HOURS".equals(timeunit)) return TimeUnit.HOURS;
        else if("DAYS".equals(timeunit)) return TimeUnit.DAYS;
        else return TimeUnit.MINUTES;
    }
}