package com.hsy.algorithm.ai0003;

/**
 * @author heshiyuan
 * @description <p>Luhn算法</p>
 * @path java/com.hsy.algorithm.ai0003
 * @date 2019/9/29 09:28
 */
public class Luhn {

    public static boolean check(int[] digits) {
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {

            // get digits in reverse order
            int digit = digits[length - i - 1];

            // every 2nd number multiply with 2
            if (i % 2 == 1) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return sum % 10 == 0;
    }
    int []num;  //位数

    public Luhn(){
        num = new int[21];
        for(int i = 0; i < num.length; i++) {
            num[i] = 0;
        }
    }

    public Luhn(int n) {
        num = new int[n];
    }
    public boolean full() {
        for(int i = 0; i < num.length; i++) {
            if(num[i] != 9) {
                return false;
            }
        }
        return true;
    }

    public void plusOne() {
        int tag = 0;    //从最后一位开始加，如果其9，将其变为0，另高一位加一，
        //如果高一位是9，其变为0，高一位加一一次类推直到全为9
        //tag == 0说明从第0位开始
        if(num[tag]!=9) {
            num[tag]++;
            return;
        }else {
            if(full())  return; //如果全为9则溢出

            //关键算法。。进位操作
            while(true) {
                num[tag]=0;
                tag++;
                if(num[tag] != 9) {
                    num[tag]++;
                    return;
                }
            }
        }
    }
    public void show() {
        for(int i = num.length-1; i >-1; i--) {
            System.out.print(num[i]);
        }
        System.out.println();
    }



    public void setElem(int pos, int n) {
        num[pos] = n;
    }

    public boolean isLuhn() {
        int OddPlus=0;  //奇数位和，在数组中为偶数位和
        int EvenPlus=0; //偶数位和，在数组中为奇数位和

        for(int i = 0; i < num.length; i+=2) {
            OddPlus+=num[i];
        }

        int num2=-999;
        for(int i = 1; i < num.length; i+=2) {
            num2 = num[i]*2;
            if (num2>9) {
                num2-=9;
            }
            EvenPlus+=num2;
        }
        OddPlus+=EvenPlus;
        if (OddPlus%10==0) {
            return true;
        }
        return false;
    }
}
