package net.chucrew;

/*
This class illustrates how to use threads.

Reference:
https://youtu.be/xvXbvrUUGMM

 */
class Hi implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; ++i) {
            System.out.println("Hi");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error in Hi");
            }
        }
    }
}

class Hello implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; ++i) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error in Hello");
            }
        }
    }
}

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable obj1 = new Hi();
        Runnable obj2 = new Hello();

        Thread t1 = new Thread(obj1,"Hi thread");
        Thread t2 = new Thread(obj2,"Hello thread");

        t1.start();
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println("Error in main");
        }
        t2.start();

        System.out.println("Thread name: " + t1.getName());
        System.out.println("Thread name: " + t2.getName());

        /*
        This video describes isAlive and the join() method:
        https://youtu.be/b3C3ODumC24

         */
        System.out.println("Is t1 alive? " + t1.isAlive());

        t1.join();
        t2.join();

        System.out.println("Is t1 alive? " + t1.isAlive());
        System.out.println("Bye");
    }
}
