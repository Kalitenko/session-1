package ru.sbt.jschool.session1;

/**
 * Created by 1 on 26.03.2018.
 */
public class additionalTasks {
    // На вход подаётся строка, содержащее число в бинарной системе счичсления.
    // Нужно вернуть десятичное число(long)
    static public long binaryToDec1(String binary){
        return Long.parseLong(binary, 2);
    }


    // На вход подаются 2 строки, содержащие двоичные числа - вернуть строку,
    // содержащую сумму этих чисел в двоичной системе счисления.
    static public long sumOfBinary(String b1, String b2){
        return 0;
    }

//    // На вход методу подаётся два массива long. Вернуть элементы,
//    // которые встречаются в обоих массивах
//    static public long[] intersection(long[] arr1, long[] arr2){
//        return 0;
//    }

    public static void main(String[] args) {

//        String bin = "11101000";
        String bin = "0";
        System.out.println(binaryToDec1(bin));


    }
}
