package com.company;
//2. Print Prime and non-prime numbers from 1 to 20 in ascending order using two threads;
public class Q2_Prime {
    public static void main(String[] args) {
        PrimeExample primeExample= new PrimeExample();
        PrimeNumber primeNumber = new PrimeNumber(primeExample,true);
        PrimeNumber primeNumber1 = new PrimeNumber(primeExample,false);
        new Thread(primeNumber).start();
        new Thread(primeNumber1).start();

    }
}
class PrimeExample {

    public synchronized void primeNumber() throws InterruptedException {
        for (int i = 1; i <= 20; i++) {
            int count =0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count <= 2) {
                System.out.println("Prime number is: " + i);
                Thread.sleep(500);
            }
            notify();
            wait();
        }

//        for (int i = 1; i <= 20; i++) {
//            boolean isPrime = true;
//            for (int j = 2; j < i; j++) {
//
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime) {
//                System.out.println("Prime number is: " + i);
//                Thread.sleep(1000);
//            }
//            notify();
//            wait();
//        }

    }

    public synchronized void notPrimeNumber() throws InterruptedException{

        for(int i=1; i<=20; i++){
            int count =0;
            for(int j=1; j<=i; j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count>2){
                System.out.println("Not a Prime number is: "+i);
                Thread.sleep(500);
            }
            notify();
            wait();
        }
//        for (int i = 1; i <= 20; i++) {
//            boolean isNonPrime = false;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isNonPrime = true;
//                }
//            }
//            if (isNonPrime) {
//                System.out.println("Non Prime number is: " + i);
//                Thread.sleep(1000);
//            }
//            notify();
//            wait();
//        }
    }
}
class PrimeNumber implements Runnable{
    private PrimeExample primeExample;
    private boolean flag;

    public PrimeNumber(PrimeExample primeExample, boolean flag) {
        this.primeExample = primeExample;
        this.flag = flag;
    }

    @Override
    public void run() {
        try{
            if(flag){
                primeExample.primeNumber();
            }
            else{
                primeExample.notPrimeNumber();
            }
        }catch (InterruptedException e){e.printStackTrace();}
    }
}