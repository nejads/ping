package com.personal.website.pinger;


import java.util.concurrent.TimeUnit;

public class Timer {
    long starts;

    public static Timer start() {
        return new Timer();
    }

    private Timer() {
        reset();
    }

    public Timer reset() {
        starts = System.currentTimeMillis();
        return this;
    }

    public long time() {
        long ends = System.currentTimeMillis();
        return ends - starts;
    }

    public long time(TimeUnit unit) {
        return unit.convert(time(), TimeUnit.MILLISECONDS);
    }
}
