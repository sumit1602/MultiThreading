package com.company;
//Q4. Write a program called ReverseHello.java that creates a thread (let's call it Thread 1).
// Thread 1 creates another thread (Thread 2); Thread 2 creates Thread 3; and so on, up to Thread 10.
// Each thread should print "Hello from Thread <num>!", but you should structure your program such that the
// threads print their greetings in reverse order.

class HelloReverse implements Runnable {
    int count;

    public HelloReverse(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            if (count < 10){
                Thread newThread = new Thread(new HelloReverse (count+1));
                newThread.setName("THREAD: "+(count + 1 ));
                newThread.start();
                newThread.join();
                Thread.sleep(1000);
            }
            System.out.println(Thread.currentThread().getName());

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

    public class Q4_ReverseHello {
        public static void main(String[] args) throws  InterruptedException{
            HelloReverse h1= new HelloReverse(1);
            Thread t1= new Thread(h1);
            t1.setName("THREAD 1");
            t1.start();
            t1.join();
        }
}
