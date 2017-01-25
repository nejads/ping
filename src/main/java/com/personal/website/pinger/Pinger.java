package com.personal.website.pinger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

public class Pinger {

    private static Logger log = LoggerFactory.getLogger(Pinger.class);


    public static void ping(String name, String url) {
        HttpClient client = new HttpClient();

        log.info("Pinging {} is started. Current time is {}.", name, new Date());
//      System.out.println("Pinging " + name + " is started. Current time is: "+ new Date());
        Timer timer = Timer.start();

        HttpMethod method_heroku = new GetMethod(url);
        try {
            client.executeMethod(method_heroku);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long passedTimeInMs = timer.time();
        log.info("Pinging {} finished successfully. Server name at response: {}. Total time elapsed: {} milliseconds.",
                name,
                method_heroku.getResponseHeader("Server").getValue(),
                passedTimeInMs);
/*
        System.out.println("Pinging " + name + " finished successfully. Server name at response: " +
                method_heroku.getResponseHeader("Server").getValue() + ". Total time elapsed: " +
                passedTimeInMs + " milliseconds.");
*/
    }

}