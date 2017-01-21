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
    @Scheduled(cron="*/20 * * * * ?")
    public void ping()
    {
        System.out.println("Pinging is started. Current time is :: "+ new Date());

        HttpClient client = new HttpClient();
        HttpMethod method_openshift = new GetMethod("http://soroush-webbsidan.rhcloud.com/");
        HttpMethod method_heroku = new GetMethod("http://soroush-webbsidan.rhcloud.com/");
        try {
            client.executeMethod(method_openshift);
            client.executeMethod(method_heroku);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Pinging finished successfully. ResponseBody: " + method_openshift.getName());

    }

}
