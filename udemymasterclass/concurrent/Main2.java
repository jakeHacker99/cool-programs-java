package udemymasterclass.concurrent;

import org.w3c.dom.ls.LSOutput;

public class Main2 {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {

        public void run() {
            System.out.println("thread 1: has lock 1");
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1: has locked lock 2");
                }
                System.out.println("Thread 1 : Released  lock 2");
            }
            System.out.println("Thread 1 : Released lock 1 ");
            System.out.println("Exiting ...");

        }

    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock2){
                System.out.println("Thread 2 : has Lock 2");
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: waiting for lock 1");
                synchronized (lock1){
                    System.out.println("Thread 2 : has lock 2 and lock 1");
                }
                System.out.println("Thead 2: released lock 1");
            }
            System.out.println("Thread 2 : relesed lock 2 ");
            System.out.println("Exiting ...");

        }
    }
}
