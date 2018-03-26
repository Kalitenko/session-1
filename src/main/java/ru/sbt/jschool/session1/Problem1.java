package ru.sbt.jschool.session1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class Problem1 {
    
    public static void main(String[] args) throws FileNotFoundException {


        class Task1 {
            void runTask() {
                System.out.println("Задача 1. Вывести все аргументы командной строки.\n");
                for (int i = 0; i < args.length; i++) {
                    System.out.println(args[i]);
                }
            }
        }


        class Task2 {
            void runTask() {
                System.out.println("\n\nЗадача 2. Вывод всех системных переменных.\n");
                Map<Object, Object> properties = System.getProperties();
                for (Object propertiesName : properties.keySet()) {
                    System.out.format("%s=%s%n",
                            propertiesName,
                            properties.get(propertiesName));
                }
            }
        }


        class Task3 {
            void runTask() {
                System.out.println("\n\nЗадача 3. Вывод всех переменных окружения.\n");
                Map<String, String> env = System.getenv();
                for (String envName : env.keySet()) {
                    System.out.format("%s=%s%n",
                            envName,
                            env.get(envName));
                }
            }
        }


        class Task4 {
            void runTask() {
                System.out.println("\n\n Задача 4\n");

                int count = 0;
                String keyString = new String("JSCHOOl1_COUNT=");

                if (args.length > 0) {
                    for (String arg : args)
                        if (arg.startsWith(keyString)) {
                            count = Integer.parseInt(arg.substring(keyString.length()));
                            //System.out.println("Количество выводов = " + count);
                            for (int i = 0; i < count; i++)
                                System.out.println("Hello, World!");
                        }
                } else if (System.getProperties().containsKey("JSCHOOl1_COUNT")) {
                    count = Integer.parseInt(System.getProperty("JSCHOOl1_COUNT"));
                    for (int i = 0; i < count; i++)
                        System.out.println("Hello, World!");
                } else if (System.getenv().containsKey("JSCHOOl1_COUNT")) {
                    count = Integer.parseInt(System.getenv("JSCHOOl1_COUNT"));
                    for (int i = 0; i < count; i++)
                        System.out.println("Hello, World!");
                } else if (System.getenv().containsKey("JSCHOOL1_PROPERTIES_FILE")) {
                    String path = System.getenv("JSCHOOL1_PROPERTIES_FILE");

                    Properties properties = new Properties();
                    try {
                        properties.load(new FileInputStream(path));
                        if (properties.containsKey("JSCHOOl1_COUNT")) {
                            count = Integer.parseInt(properties.getProperty("JSCHOOl1_COUNT"));
                            for (int i = 0; i < count; i++)
                                System.out.println("Hello, World!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Задайте \n " +
                            " параметр вида `JSCHOOl1_COUNT=XXX`, \n" +
                            " или системную настройку вида `JSCHOOl1_COUNT=XXX`, \n " +
                            " или переменную окружения вида `JSCHOOl1_COUNT=XXX` \n " +
                            " где XXX - число выводов \"Hello, World!\" \n " +
                            " или переменную окружения вида `JSCHOOL1_PROPERTIES_FILE=XXX` \n " +
                            " где XXX - путь к файлу с настройками"
                            );
                }
            }
        }

        new Task1().runTask();
        new Task2().runTask();
        new Task3().runTask();
        new Task4().runTask();



    }

}




