package com.personal.website;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "pinger")
public class Pinger
{
    @Scheduled(cron="*/5 * * * * ?")
    public void ping()
    {
        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
    }
}
