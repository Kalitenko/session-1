package ru.sbt.jschool.session1;

import java.util.ArrayList;

/**
 * Created by 1 on 26.03.2018.
 */
public class additionalTasks {
    // На вход подаётся строка, содержащее число в бинарной системе счичсления.
    // Нужно вернуть десятичное число(long)
    static public long binaryToDec1(String binary){
        return Long.parseLong(binary, 2);
    }

    // наверное приветствуется более сложное решение))
    static int symbol(char ch){
        if(ch == '0')
            return 0;
        else
            return 1;
    }


    static public long binaryToDec2(String binary) {

        boolean flag = false;
        int start = 0;
        int len = binary.length();

        if (binary.charAt(0) == '-') {
            flag = true;
            start = 1;
        } else if (binary.charAt(0) == '+')
            start = 1;

        // принимаем за результат последний разряд
        long result = 1 * symbol((binary.charAt(len - 1)));

        for (int i = 1; i < len - start; i++) {
                result += symbol(binary.charAt(len - 1 - i)) * Math.pow(2,i);
        }
        return flag ? -result: result;
    }


    // На вход подаются 2 строки, содержащие двоичные числа - вернуть строку,
    // содержащую сумму этих чисел в двоичной системе счисления.
    static public long sumOfBinary(String b1, String b2){
        return Long.parseLong(b1,2) + Long.parseLong(b2,2);
    }

    // На вход методу подаётся два массива long. Вернуть элементы,
    // которые встречаются в обоих массивах
    static public long[] intersection(long[] arr1, long[] arr2){

        ArrayList<Long> coincidences = new ArrayList<Long>();
        int len = 0;

        if(arr1.length <= arr2.length)
            len = arr1.length;
        else
            len = arr2.length;


        for (int i = 0; i < len; i++)
            if(arr1[i] == arr2[i])
                coincidences.add(arr1[i]);

        long[] result = new long[coincidences.size()];

        for (int i = 0; i < result.length; i++)
            result[i] = coincidences.get(i);

        return result;
    }

    public static void main(String[] args) {


        String bin = "-11000110111001101001";

        System.out.println("binaryToDec1(bin) = " + binaryToDec1(bin));
        System.out.println("binaryToDec1(bin) = " + binaryToDec2(bin));

        String bin1 = "+11000110111001101001";
        String bin2 = "-11000110111001101001";
        String bin3 = "1001101001";
        String bin4 = "-1100011011101001";

        System.out.println("sumOfBinary(bin1, bin2) = " + sumOfBinary(bin1, bin2));
        System.out.println("sumOfBinary(bin3, bin4) = " + sumOfBinary(bin3, bin4));

        long arrBin1[] = {25, 151, 1235, 1235 ,61, 624, 34, 235, 44, 44, 664, 235, 84};
        long arrBin2[] = {25, 151, 1235, 233 , 77 , 62, 34, 235, 34};

        long intersection[] = intersection(arrBin1, arrBin2);

        for(int i = 0; i < intersection.length; i++)
        {
            System.out.println("intersection[" + i + "] = " + intersection[i]);
        }

    }
}
