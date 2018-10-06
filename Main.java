package com.company;

class Hi1 implements Runnable{
    public void run()
    {
        for(int i=1; i<5; i++)
        {
            System.out.println("hi");
            try{Thread.sleep(1000);} catch (Exception e){}
        }
    }
}
class Hello1 implements Runnable{
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("hello");
            try{Thread.sleep(1000);} catch (Exception e){}
        }
    }
}




public class Main {

    public static void main(String[] args) {
	Hi1 obj1 = new Hi1();
	Hello1 obj2 = new Hello1();

	Thread t1= new Thread();
	Thread t2 = new Thread();


	t1.start();
        try{Thread.sleep(1000);} catch (Exception e){}
    t2.start();
    }
}
