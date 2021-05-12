package ru.mycompany;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        fillMap();
        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            if(str.equals("exit")){
                return;
            }
            String[] array = str.split(" ");

            int x, y;

            if ((x = test(array[0])) != 0 && (y = test(array[2])) != 0) {
                int res = result(array[1], x, y);
                System.out.println(resRome(res));

            } else {
                x = Integer.parseInt(array[0]);
                y = Integer.parseInt(array[2]);
                System.out.println(result(array[1], x, y));
            }
        }
    }

    public static int test(String x){
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            if(x.equals(pair.getKey())){
                return  pair.getValue();
            }
        }
        return 0;
    }

    public static String testRome(int number){
        for (Map.Entry<String, Integer> pair : map.entrySet()){
            if(number == pair.getValue()){
                return pair.getKey();
            }
        }
        return "";
    }

    public static int result(String sign, int x, int y){
        switch (sign){
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                System.out.println("?");
                return 0;
        }
    }

    public static void fillMap() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("RomanNumerals"))){
            while(reader.ready()){
                String[] n = reader.readLine().split(" ");
                map.put(n[0], Integer.parseInt(n[1]));
            }
        }
    }

    public static String resRome(int res){
        if(res <= 10){
            if(res == 10){
                return "X";
            } else {
                int first = res / 10;
                int second = res % 10;
                String x = testRome(first);
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 20){
            if(res == 20){
                return "XX";
            } else {
                int first = 10;
                int second = res % 10;
                String x = testRome(first);
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 30){
            if(res == 30){
                return "XXX";
            } else {
                String x = "XX";
                int second = res % 10;
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 40){
            if(res == 40){
                return "XL";
            } else {
                String x = "XXX";
                int second = res % 10;
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 50){
            if(res == 50){
                return "L";
            } else {
                String x = "XL";
                int second = res % 10;
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 60){
            if(res == 60) {
                return "LX";
            } else {
                String x = "L";
                int second = res % 10;
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 70){
            if(res == 70){
                return "LXX";
            } else {
                String x = "LX";
                int second = res % 10;
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 80) {
            if(res == 80){
                return "LXXX";
            } else {
                String x = "LXX";
                int second = res % 10;
                String y = testRome(second);
                return x + y;
            }
        } else if (res <= 90) {
            if(res == 90){
                return "XC";
            } else {
                String x = "LXXX";
                int second = res % 10;
                String y = testRome(second);
                return x + y;
            }
        } else if(res == 100){
            return "C";
        }
        return null;
    }
}
