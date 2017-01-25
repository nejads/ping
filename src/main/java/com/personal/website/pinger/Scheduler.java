package com.personal.website.pinger;

import com.personal.website.config.PingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component(value = "scheduler")
@EnableConfigurationProperties(PingProperties.class)
public class Scheduler {

    private static PingProperties properties;

    @Autowired
    public Scheduler(PingProperties properties) {
        this.properties = properties;
    }

    @Async
    @Scheduled(fixedDelay = 365 * 24 * 60  * 60 * 1000)
    public void schedule() {

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Task.getTasks().forEach(task -> {
            executorService.scheduleWithFixedDelay(task,
                    properties.getInitialdelay(),
                    randomDelay(1, properties.getInterval()),
                    properties.getTimeUnit());
        });

    }

    private int randomDelay(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
