package com.personal.website;

import java.util.ArrayList;
import java.util.List;

public class Task {

    public static List<Runnable> getTasks() {
        final Runnable herokuTask = () -> Pinger.ping("Heroku", "https://pingeropenshift.herokuapp.com/");
        final Runnable openshiftTask = () -> Pinger.ping("Openshift", "http://soroush-webbsidan.rhcloud.com/");
        final List<Runnable> runnables = new ArrayList<>();
        runnables.add(herokuTask);
        runnables.add(openshiftTask);

        return runnables;
    }
}
