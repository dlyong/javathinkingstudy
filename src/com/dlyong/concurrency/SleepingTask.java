package com.dlyong.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends ListOff {

    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                // jdk1.5之前
                //Thread.sleep(100);
                // jdk1.5之后
                TimeUnit.MILLISECONDS.sleep(1000);

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SleepingTask());
        }
        executorService.shutdown();
    }
}
