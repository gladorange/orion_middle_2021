package com.orion.lesson11;


public class DeadLockExample {

    static final Object oneMonitor = new Object();
    static final Object anotherMonitor = new Object();


    public static void main(String[] args) throws InterruptedException {
        final LockAnotherThenOneThread firstThread = new LockAnotherThenOneThread();
        firstThread.start();


        final LockOneThenAnotherThread secndThread = new LockOneThenAnotherThread();
        secndThread.start();

       /* final Thread firstThread = new Thread(() -> lockTwoMonitors("Поток 1"));
        firstThread.start();


        final Thread secndThread = new Thread(() -> lockTwoMonitors("Поток 2"));
        secndThread.start();

        System.out.println("Конец main");*/
    }

    static class LockOneThenAnotherThread extends Thread{

        public LockOneThenAnotherThread() {
            setName("One- Another");
        }

        @Override
        public void run() {

            synchronized (oneMonitor) {
                System.out.println("Поток 1:Один монитор захвачен");
                try {
                    Thread.sleep(1000);
                    synchronized (anotherMonitor) {
                        System.out.println("Оба монитора захвачены");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    static class LockAnotherThenOneThread extends Thread{

        public LockAnotherThenOneThread() {
            setName("Another - one");
        }

        @Override
        public void run() {

            synchronized (anotherMonitor) {
                System.out.println("Поток 2:Один монитор захвачен");
                try {
                    Thread.sleep(1000);
                    synchronized (oneMonitor) {
                        System.out.println("Оба монитора захвачены");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }







    static synchronized void lockTwoMonitors(String threadName) {
        synchronized (oneMonitor) {
            System.out.println(threadName + ":Один монитор захвачен");
            try {
                Thread.sleep(1000);
                synchronized (anotherMonitor) {
                    System.out.println(threadName + ": Оба монитора захвачены");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
