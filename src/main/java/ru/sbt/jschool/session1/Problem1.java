package ru.sbt.jschool.session1;

import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {

/*        System.out.println("Задача 1. Вывести все аргументы командной строки.\n");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }*/


/*        System.out.println("\n\nЗадача 2. Вывод всех системных переменных.\n");
        Map<Object, Object> properties = System.getProperties();
        for (Object propertiesName : properties.keySet()) {
            System.out.format("%s=%s%n",
                    propertiesName,
                    properties.get(propertiesName));

        }*/

/*        System.out.println("\n\nЗадача 3. Вывод всех переменных окружения.\n");
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }*/

        System.out.println("\n\n Задача 4\n");

/*        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }*/

        String keyString = new String ("JSCHOOl1_COUNT=");

        for(String arg:args)
            if(arg.startsWith(keyString)) {
                int count = Integer.parseInt(arg.substring(keyString.length()));
                //System.out.println("Количество выводов = " + count);
                for (int i = 0; i < count; i++)
                    System.out.println("Hello, World!");

            }


    }



}

