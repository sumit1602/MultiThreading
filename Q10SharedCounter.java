package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Write a program called SharedCounter.java in which 5 threads each increment a shared int counter 1000 times.
//When all the threads have finished, print the final value of the counter.
//If the initial value is zero, do you always get 5000?
//Arrange your code to get the correct output. Note: - use a thread pool of 2 threads.

class Increment implements Runnable{
    Counter c;
    public Increment(Counter counter)
    {
        this.c = counter;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            c.inc();
        }
    }
}
class Counter{
    static int count = 0;
    public synchronized void inc() {
        count++;
    }
    public int getCount() {
        return this.count;
    }
}
public class Q10SharedCounter
{
    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        Counter c = new Counter();
        for (int i = 0; i < 5; i++) {
            Increment increment = new Increment(c);
            executor.submit(increment);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println(c.getCount());
    }
}