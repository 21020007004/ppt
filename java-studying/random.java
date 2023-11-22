package com.example.demo.example;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class random {
    public static void main(String[] args) {
        //某公司开发部5名人员，要进行醒目进展汇报演讲，现在采取随机排名后进行汇报
        //请先依次录入5名员工的工号，然后展示出一组随机的排名顺序
        int[] arr= new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请你输入当前第"+ (i + 1) +"员工的工号：");
            int code = sc.nextInt();
            arr[i]=code;
        }
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length);
            int swap = arr[index];
            arr[index] = arr[i];
            arr[i] = swap;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
    }
}
