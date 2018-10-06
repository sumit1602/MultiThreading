package com.company;

class Hi extends Thread {
    public void run()
    {
        for(int i=1; i<5; i++)
        {
            System.out.println("hi");
            try{Thread.sleep(1000);} catch (Exception e){}
        }
    }
}
class Hello extends Thread {
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("hello");
            try{Thread.sleep(1000);} catch (Exception e){}
        }
    }
}
public class ThreadDemo{
    public static void main(String[] args) {
        Hi hi = new Hi();
        Hello hello = new Hello();
        hi.start();
        try{Thread.sleep(10);} catch (Exception e){}
        hello.start();
//        hi.run();
//        hello.run();
    }
}