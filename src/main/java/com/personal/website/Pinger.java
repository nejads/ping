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
        System.out.println("Pinging Openshift is started. Current time is :: "+ new Date());

        HttpClient client = new HttpClient();
        HttpMethod method_openshift = new GetMethod("http://soroush-webbsidan.rhcloud.com/");
        try {
            client.executeMethod(method_openshift);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Pinging Openshift finished successfully. Server: " +
                method_openshift.getResponseHeader("Server").getValue());


/*        System.out.println("Pinging Heroku is started. Current time is :: "+ new Date());
        HttpMethod method_heroku = new GetMethod("https://pingeropenshift.herokuapp.com/");
        try {
            client.executeMethod(method_heroku);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Pinging Heroku finished successfully. Server: " +
                method_heroku.getResponseHeader("Server").getValue());
*/ 
    }

}
