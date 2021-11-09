package com.orion.lesson11;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {


    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        final ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(() -> System.out.println(LocalDateTime.now()), 0, 1, TimeUnit.SECONDS);

        Thread.sleep(5000);
        scheduledFuture.cancel(true);
    }
}
