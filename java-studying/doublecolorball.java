package com.example.demo.example;

import java.util.Random;
import java.util.Scanner;

public class doublecolorball {
    public static void main(String[] args) {
        //双色球模拟器
    int[] userNumbers = userSelectNumbers();
    int[] luckNumbers = createLuckNumber();
    judge(userNumbers,luckNumbers);
    }
    //让用户投入以一组球
    public static int[] userSelectNumbers(){
        //
        int[] numbers = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numbers.length-1; i++) {
            System.out.println("请你输入"+(i+1)+"个红球号码（1-33之间，不能重复）");
            while (true) {
                int number = sc.nextInt();
                //判断输入是否正确
                if(number<1||number>33){
                    System.out.println("对不起你的输入有错误，请重新输入：");
                }else {
                    //
                    if (exist(numbers,number)){
                        System.out.println("对不起，你当前输入重复，请重新输入：");
                    }else {
                        numbers[i]=number;
                        break;
                    }
                }
            }
        }
        System.out.println("请你输入最后一个蓝球号码（1-16）：");
        int num=sc.nextInt();
        while (true) {
            if(num<1||num>16){
                System.out.println("对不起，你输入的代码错误，请重新输入：");
            }else {
                numbers[numbers.length-1] =num;
                break;
            }
        }
        return numbers;
    }
//检测输入的红球号是否重复
    private static boolean exist(int[] numbers, int number) {
        int mark=numbers.length;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==0){
                break;
            }
            if(numbers[i]==number) {
               return true;
            }
        }

            return false;
    }
    //设计一个方法，随机一组中奖号码出来
    public static int[] createLuckNumber(){
     int[] numbers = new int[7];
     Random r = new Random();
        for (int i = 0; i < numbers.length-1; i++) {
            while (true) {
                int number = r.nextInt(33)+1;
                if(!exist(numbers,number)){
                    numbers[i]=number;
                    break;
                }
            }
        }
        numbers[6] = r.nextInt(16)+1;
        return numbers;
    }
    //判断是否中奖
    public static void judge(int[] userNumbers, int[] luckNumbers){
        int redcount =0;
        int bluecount = 0;
        for (int i = 0; i < luckNumbers.length-1; i++) {
            for (int j = 0; j < luckNumbers.length; j++) {
                if(userNumbers[i]==luckNumbers[j]){
                    redcount++;
                    break;
                }
            }

        }
        bluecount = userNumbers[6] == luckNumbers[6]?1:0;
        System.out.println("你命中红球数量是：" + redcount);
        System.out.println("你命中蓝球数量是：" + bluecount);

        if(redcount == 6&&bluecount ==1){
            System.out.println("恭喜你，中奖1000万，可以开始享受人生了~~");
        } else if (redcount == 6&&bluecount ==0) {
            System.out.println("恭喜你，中奖500万，可以开始稍微享受人生了~~");
        } else if (redcount == 5&&bluecount ==1) {
            System.out.println("恭喜你，中奖3000元，可以出去吃顿小龙虾了~~");
        } else if (redcount == 5&&bluecount ==0||redcount == 4&&bluecount ==1) {
            System.out.println("恭喜你，中了小奖，200元~");
        } else if (redcount == 4&&bluecount ==0||redcount == 3&&bluecount ==1) {
            System.out.println("恭喜你，中了小奖，10元~");
        } else if (redcount < 3&&bluecount ==1) {
            System.out.println("恭喜你，中了小奖，5元~");
        } else {
            System.out.println("感谢参与");
        }
    }
}
