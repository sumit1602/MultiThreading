package com.company;
//3. Print pattern 1 2 3 1 2 3.... using three different threads

public class Q3_Pattern {
    static Object monitor = new Object();
    static boolean one = true;
    static boolean two = false;
    static boolean three = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new SequenceDisplay(1));
        Thread t2 = new Thread(new SequenceDisplay(2));
        Thread t3 = new Thread(new SequenceDisplay(3));
        t1.start();
        t2.start();
        t3.start();
    }

    static class SequenceDisplay implements Runnable {

        int threadId;

        SequenceDisplay (int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            print();
        }
        private void print() {
            try {
                while (true) {
                    Thread.sleep(500);
                    synchronized (monitor) {
                        if (1 == threadId) {
                            if (!one) {
                                monitor.wait();
                            } else {
                                System.out.print(threadId + " ");
                                one = false;
                                two = true;
                                three = false;
                                monitor.notifyAll();
                            }
                        }
                        if (2 == threadId) {
                            if (!two) {
                                monitor.wait();
                            } else {
                                System.out.print(threadId + " ");
                                one = false;
                                two = false;
                                three = true;
                                monitor.notifyAll();
                            }
                        }
                        if (3 == threadId) {
                            if (!three) {
                                monitor.wait();
                            } else {
                                System.out.print(threadId + " ");
                                one = true;
                                two = false;
                                three = false;
                                monitor.notifyAll();
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}