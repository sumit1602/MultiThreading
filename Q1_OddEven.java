package com.company;
//1. Print Odd and even numbers from 1 to 20 in ascending order using two threads;

public class Q1_OddEven {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        OddEvenExample oddEvenExample = new OddEvenExample(main1, true);
        OddEvenExample oddEvenExample1 = new OddEvenExample(main1, false);
        Thread t1= new Thread(oddEvenExample);
        Thread t2 = new Thread(oddEvenExample1);
//        new Thread(oddEvenExample).start();
//        new Thread(oddEvenExample1).start();
        t1.start();
        t2.start();

    }
    }

    class OddEvenExample implements Runnable {
        private Main1 main1;
        private boolean flag;

        public OddEvenExample(Main1 main1, boolean flag) {
            this.main1 = main1;
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                if (flag) {
                    main1.oddPrint();
                } else {
                    main1.evenPrint();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    class Main1 {
        public synchronized void oddPrint() throws InterruptedException {
            for (int i = 0; i <= 20; i++) {
                if (i % 2 == 0) {
                    wait();
                }
                else
                {System.out.println("ODD NUMBER IS: " + i);
                notify();}
            }
        }

        public synchronized void evenPrint() throws InterruptedException {
            for (int i = 0; i <= 20; i++) {
                if (i % 2 != 0) {
                    wait();
                }
                else
                {System.out.println("EVEN NUMBER IS: " + i);
                notify();}
            }
        }
    }


