package com.company;

import java.util.Arrays;

class Q5_SumOfElementsOfArray extends Thread{
    private int low, high;
    private int[] nums;
    private int sum = 0;

    public Q5_SumOfElementsOfArray(int[] n, int low, int high) {
        this.nums = n;
        this.low = low;
        this.high = high;
    }
    @Override
    public void run() {
        for (int i = low; i < high; i++) {
            sum = Math.addExact(sum, nums[i]);
        }
    }
    public static void main(String[] args) {
        try {
            int[] numbers = Q5_SumOfElementsOfArray.populateData();
            int m = Q5_SumOfElementsOfArray.findSum(numbers);
            System.out.println(Arrays.toString(numbers));
            System.out.println("Its sum value is: " + m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static int findSum(int[] numbers) throws InterruptedException {
        int length = numbers.length;
        int sum = 0;
        int n = 4;
        Q5_SumOfElementsOfArray[] threads = new Q5_SumOfElementsOfArray[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new Q5_SumOfElementsOfArray(numbers,(i * length) / n, ((i + 1) * length) / n);
            threads[i].start();
        }
        for (int i = 0; i < n; i++) {
            threads[i].join();
            sum = Math.addExact(threads[i].sum, sum);
        }
        return sum;
    }

    public static int[] populateData() {
        int a[] = {1,2,3,4,5};
        return a;
    }
}