package com.web;

public class Test {
    public static void main(String[] args) {
        int []num = new int[20];
        num[0]=0;
        num[1]=1;

        for (int i=2;i<20;i++){
            num[i]=num[i-1]+num[i-2];
        }
        for (int j=1;j<=20;j++){
           /* if (j%5==0){
                System.out.println();
            }*/
            System.out.println(num[j-1]);
        }
    }
}
