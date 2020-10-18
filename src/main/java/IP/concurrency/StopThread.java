package main.java.IP.concurrency;

import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

public class StopThread {

    public static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (!stopRequested){
                   i++;
                }
            }
        });


        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }


}
