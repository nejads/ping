package com.personal.website;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pinger
{
    public static void ping(String name, String url) {
        HttpClient client = new HttpClient();

        System.out.println("Pinging " + name + " is started. Current time is: "+ new Date());
        Timer timer = Timer.start();

        HttpMethod method_heroku = new GetMethod(url);
        try {
            client.executeMethod(method_heroku);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long passedTimeInMs = timer.time();
        System.out.println("Pinging " + name + " finished successfully. Server name at response: " +
                method_heroku.getResponseHeader("Server").getValue() + ". Total time elapsed: " +
                passedTimeInMs + " milliseconds.");
    }

}