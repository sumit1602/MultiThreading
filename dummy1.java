package com.company;

public class dummy1 {

        public static void main(String[] args) {
            Printer1 print = new Printer1();
            Thread t1 = new Thread(new EvenOdd(print, 20, false));
            Thread t2 = new Thread(new EvenOdd(print, 20, true));
            t1.start();
            t2.start();
        }

    }
    class EvenOdd implements Runnable {

        private int max;
        private Printer1 print;
        private boolean isEvenNumber;

        EvenOdd(Printer1 print, int max, boolean isEvenNumber) {
            this.print = print;
            this.max = max;
            this.isEvenNumber = isEvenNumber;
        }

        @Override
        public void run() {

            int number = isEvenNumber == true ? 2 : 1;
            while (number <= max) {

                if (isEvenNumber) {
                    print.printEven(number);
                } else {
                    print.printOdd(number);
                }
                number += 2;
            }

        }

    }

    class Printer1 {

        boolean isOdd = false;

        synchronized void printEven(int number) {

            while (isOdd == false) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even:" + number);
            isOdd = false;
            notifyAll();
        }

        synchronized void printOdd(int number) {
            while (isOdd == true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd:" + number);
            isOdd = true;
            notifyAll();
        }

    }
