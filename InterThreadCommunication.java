package com.company;
// producer consumer example is best to understand interthread communication

class V{
    int i;

//    public int getI() {
//        return i;
//    }

    boolean valuSet= false;
    public synchronized void getI(){
        while(!valuSet){
            try { wait();}catch (Exception e){};
        }
        System.out.println("get: "+ i);
        valuSet=false;
        notify();
    }

    public synchronized void setI(int i) {
        while(valuSet){
            try { wait();}catch (Exception e){};
        }
        System.out.println("put: "+ i);
        this.i = i;
        valuSet=true;
        notify();
    }
}

class Producer implements Runnable{
    V v;

    public Producer(V v) {
        this.v= v;
        Thread t1 = new Thread(this,"Producer");
        t1.start();

    }

    @Override
    public void run() {
        int i=0;
        while (true){
            v.setI(i++);
               try{Thread.sleep(2000);}catch (Exception e){};
        }
    }
}

class Consumer implements Runnable{
    V v;

    public Consumer(V v) {
        this.v = v;
        Thread t2 = new Thread(this,"Consumer");
        t2.start();
    }

    @Override
    public void run() {
        while(true){
            v.getI();
            try{Thread.sleep(2000);}catch (Exception e){};
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        V v= new V();
        new Producer(v);
        new Consumer(v);

    }
}
