package ru.skipy.threads;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotifyAllTest {

    static final DateFormat FORMAT = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        Object sync = new Object();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new WaitingThread(sync));
            t.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("main:: Interrupted: " + e.getMessage());
        }
        synchronized (sync) {
            log("main::  Calling notifyAll");
            sync.notifyAll();
            log("main::  Sleeping for 3 seconds");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("main::  Interrupted: " + e.getMessage());
            }
            log("main:: Exiting synchronized block");
        }
    }

    static void log(String msg) {
        System.out.println(FORMAT.format(new Date()) + ": " + msg);
    }

    static class WaitingThread implements Runnable {

        static int nextId = 1;

        private Object sync;
        private int id;

        public WaitingThread(Object sync) {
            this.sync = sync;
            id = nextId++;
        }

        @Override
        public void run() {
            synchronized (sync) {
                log("own(" + id + ")::Waiting");
                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    log("own(" + id + ")::Interrupted: " + e.getMessage());
                }
                log("own(" + id + ")::Running again");
                log("own(" + id + ")::Sleeping for 1 second");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log("own(" + id + ")::Interrupted: " + e.getMessage());
                }
                log("own(" + id + ")::Finishing");
            }
        }
    }
}

