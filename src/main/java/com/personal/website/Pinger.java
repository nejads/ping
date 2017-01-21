package com.personal.website;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component(value = "pinger")
public class Pinger
{
    @Scheduled(cron="*/5 * * * * ?")
    public void ping()
    {
        System.out.println("Pinging is started. Current time is :: "+ new Date());

        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("http://soroush-webbsidan.rhcloud.com/");
        try {
            int i = client.executeMethod(method);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Pinging finished successfully. ResponseHeader: " + method.getResponseHeaders());

    }

}
