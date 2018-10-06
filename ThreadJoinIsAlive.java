package com.company;

public class ThreadJoinIsAlive {

        public static void main(String[] args) throws Exception {
            Thread t1= new Thread(() ->
            {
                for(int i=1; i<5; i++)
                {
                    System.out.println("hi");
                    try{Thread.sleep(1000);} catch (Exception e){}
                }

            },"HI THREAD");
            Thread t2 = new Thread(() -> {
                for (int i = 1; i < 5; i++) {
                    System.out.println("hello");
                    try{Thread.sleep(1000);} catch (Exception e){}
                }
            },"Hello Thread");


//            //for setting name of thread
//            t1.setName("hi thread");
//            t2.setName("hello thread");
//            //for getting name of thread
            System.out.println(t1.getName());
            System.out.println(t2.getName());

            t1.start();
            try{Thread.sleep(10);} catch (Exception e){}
            t2.start();

            t1.join();
            t2.join();
            System.out.println(t1.isAlive());
            //join will make your main thread wait to join t1 and t2
            //when t1 and t2 done their job then it will join to main thread
            //but it may throw an error soo will hai to throw exception at main
            System.out.println("Bie");
            System.out.println(t1.isAlive());
            for(int i=0; i<10; i++){
                System.out.print(i);
            }
        }
    }


