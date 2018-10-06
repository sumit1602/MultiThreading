package com.company;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1= new Thread(() ->
        {
            for(int i=1; i<5; i++)
            {
                System.out.println("hi "+ Thread.currentThread().getPriority());
                try{Thread.sleep(1000);} catch (Exception e){}
            }

        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("hello");
                try{Thread.sleep(1000);} catch (Exception e){}
            }
        });

//       t1.setPriority(1);
//       t2.setPriority(9);
       t1.setPriority(Thread.MAX_PRIORITY);
       t2.setPriority(Thread.MIN_PRIORITY);

        System.out.println(t1.getPriority());  //By deafult same priority 5
        System.out.println(t2.getPriority());  //By deafult same priority 5
        t1.start();
        try{Thread.sleep(10);} catch (Exception e){}
        t2.start();

    }
}
