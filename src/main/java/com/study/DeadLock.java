package com.study;

public class DeadLock {

    public static void main(String[] argv) {
        Object str1 = "Hello";
        Object str2 = "World";

        Thread t1 = new MyThread("Thread-1", str1, 500, str2);
        Thread t2 = new MyThread("Thread-2", str2, 500, str1);

        t1.start();
        sleepQuitly(510);
        t2.start();
    }

    public static class MyThread extends Thread {
        private Object waitFor1;
        private int sleepTime;
        private Object waitFor2;

        public MyThread(String name, Object waitFor1, int sleepTime, Object waitFor2) {
            super(name);
            this.waitFor1 = waitFor1;
            this.sleepTime = sleepTime;
            this.waitFor2 = waitFor2;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is waiting for object " + waitFor1);
            synchronized (waitFor1) {
                System.out.println(Thread.currentThread().getName() + " got lock for object " + waitFor1);
                sleepQuitly(sleepTime);
                System.out.println(Thread.currentThread().getName() + " is waiting for object " + waitFor2);
                synchronized (waitFor2) {
                    System.out.println(Thread.currentThread().getName() + " got lock for object " + waitFor2);
                    System.out.println(Thread.currentThread().getName() + " got both locks");
                }
            }
        }
    }

    private static void sleepQuitly(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
