package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 1 on 26.03.2018.
 */

class HW1 implements PropertyHelper{

    private String args_HW1[];
    private String pathFile;
    Properties properties;

    HW1(String[] args, String path){
        args_HW1 = args;
        pathFile = path;
        properties = new Properties();
        // в случае пустой строки, загрузки properties из файла не будет
        if (path.equals(""))
            properties = System.getProperties();
        // иначе загрузка из файла
        else {
            try {
                properties.load(new FileInputStream(pathFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Если передан аргумент командной строки вида `name=XXX`, то возвращается он.
    @Override
    public String stringValue(String name) {
        if(args_HW1.length > 0) {
            for(String arg : args_HW1) {
                if (arg.startsWith(name + "="))
                    return arg;
            }
        }
        return null;
    }

    // Если существует системная настройка вида `name=XXX`, то возвращается её значение.
    // Если определена переменная окружения вида `name=XXX`, то используется она.
    // Если property файл, находящийся по пути, переданном в конструкторе содержит настройку name, то используется она.


    @Override
    public Integer integerValue(String name) {

        // Если существует системная настройка вида `name=XXX`, то возвращается её значение.
        if(properties.containsKey(name))
            return Integer.parseInt(properties.getProperty(name));


        // Если определена переменная окружения вида `name=XXX`, то используется она.
        if(System.getenv().containsKey(name))
            return Integer.parseInt(System.getenv(name));

        return null;
    }

    @Override
    public Double doubleValue(String name) {

        // Если существует системная настройка вида `name=XXX`, то возвращается её значение.
        if(properties.containsKey(name))
            return Double.parseDouble(properties.getProperty(name));


        // Если определена переменная окружения вида `name=XXX`, то используется она.
        if(System.getenv().containsKey(name))
            return Double.parseDouble(System.getenv(name));

        return null;

    }
}

public class homework {
    public static void main(String[] args) {

        HW1 homework1 = new HW1(args, "");
        String path = "D:\\programming\\learning\\sbt\\session-1\\src\\main\\java\\ru\\sbt\\jschool\\session1\\file.txt";
        HW1 homework2 = new HW1(args, path);
        HW1 homework3 = new HW1(args, "");


        System.out.println("homework1.stringValue(\"fff\"): " + homework1.stringValue("fff"));
        System.out.println("homework2.integerValue(\"integer_var\"): " + homework2.integerValue("integer_var"));
        System.out.println("homework2.doubleValue(\"double_var\"): " + homework2.doubleValue("double_var"));
        System.out.println("homework3.integerValue(\"xxx\"): " + homework3.integerValue("xxx"));
        System.out.println("homework3.doubleValue(\"yyy\"): " + homework3.doubleValue("yyy"));


    }
}
