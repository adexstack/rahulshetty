package com.building;


import com.bulding.myseries.Series;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        for(int i=0; i<=10; i++){
            System.out.println(Series.nSum(i));
        }

        System.out.println("*********************************");
        for(int i=0; i<=10; i++){
            System.out.println(Series.factorial(i));
        }

        System.out.println("*********************************");
        for(int i=0; i<=10; i++){
            System.out.println(Series.fibonacci(i));
        }

    }
}
