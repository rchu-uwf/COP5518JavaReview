package net.chucrew;

import java.util.concurrent.locks.ReentrantLock;

public class MutexLock {

    private static ReentrantLock myMutex = new ReentrantLock();
    private static int criticalCounter = 0;
    public static final int LOOP_MAX = 100000;

    /*
    This class illustrates how to use mutex locks.
     */

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < LOOP_MAX; ++i) {
                incrementCriticalCounterNoLock();
                //incrementCriticalCounterWithLock();

            }
        }
    }

    /**
     * incrementCriticalCounterNoLock
     * This method increments the counter variable without using a lock.
     * You will have a race condition here.
     */
    private static int incrementCriticalCounterNoLock() {
        return ++criticalCounter;
    }

    /**
     * incrementCriticalCounterWithLock
     * This method increments the counter variable with lock.
     *
     */
    private static int incrementCriticalCounterWithLock() {

        myMutex.lock();

        // Critical Section
        try {
            return ++criticalCounter;
        } finally {
            myMutex.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable obj1 = new MyThread();
        Runnable obj2 = new MyThread();

        Thread t1 = new Thread(obj1, "First thread");
        Thread t2 = new Thread(obj2, "Second thread");


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The counter value is: " + criticalCounter);
        System.out.println("You should see a value like: " + LOOP_MAX*2);
    }
}


