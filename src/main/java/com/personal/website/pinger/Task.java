package com.personal.website.pinger;

import com.personal.website.config.PingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(PingProperties.class)
public class Task {

    private static PingProperties properties;

    @Autowired
    public Task(PingProperties properties) {
        this.properties = properties;
    }

    public static List<Runnable> getTasks() {
        final List<Runnable> runnables = new ArrayList<>();

        properties.getUrlList().forEach(url -> {
            Runnable task = () -> Pinger.ping(getUrlName(url), url);
            runnables.add(task);
        });

        return runnables;
    }

    private static String getUrlName(String url) {
        if(url.toLowerCase().contains("heroku")){
            return "Heroku";

        } else if(url.toLowerCase().contains("rhcloud")) {
            return "Openshift";

        } else {
            return url;
        }

    }

}
