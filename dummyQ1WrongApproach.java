package com.company;

import java.util.Arrays;
import java.util.List;

//1. Print Odd and even numbers from 1 to 20 in ascending order using two threads;
public class dummyQ1WrongApproach {
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            for(int x=0; x<=25; x++){
                if (x % 2 == 0){
                    System.out.println("Thread Even: "+x);
                    try{Thread.sleep(2000);}catch (Exception e){}
                }
            }
        });
        Thread t2 = new Thread(()->{
            for(int x=0; x<=25; x++){
                if (x % 2 != 0){
                    System.out.println("Thread odd: "+x);
                    try{Thread.sleep(2000);}catch (Exception e){}
                }
            }
        });

t1.start();
try{Thread.sleep(1000);} catch (Exception e){}
t2.start();
    }
}
