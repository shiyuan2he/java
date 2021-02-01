package com.hsy.java.exercise.formatter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author heshiyuan
 * @description <p>
 *     题目：https://www.hackerrank.com/challenges/java-currency-formatter/problem
 * </p>
 * @path java/com.hsy.java.exercise.formatter
 * @date 10/11/2018 23:26
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@126.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        String us = usFormat.format(payment);
        String india = formatter.format(payment);
        String china = chinaFormat.format(payment);
        String france = franceFormat.format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
