package com.personal.website.pinger;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component(value = "scheduler")
public class Scheduler {

    @Async
    @Scheduled(fixedDelay = 365 * 24 * 60  * 60 * 1000)
    public void schedule() {

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        Task.getTasks().forEach(task -> {
            executorService.scheduleWithFixedDelay(task,
                    0,
                    randomDelay(1, 14),
                    TimeUnit.MINUTES);
        });

    }

    private int randomDelay(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
