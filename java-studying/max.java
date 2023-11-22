package com.example.demo.example;

public class max {
    public static void main(String[] args) {
        int[] arr = {15,9000,10000,20000,9500,-5};
        int max = arr[0];
        for (int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("数组中最大的数为"+max);
    }
}
