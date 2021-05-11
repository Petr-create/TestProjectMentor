package ru.mycompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        //и для ответа
        map.put("XI", 11);
        map.put("XII", 12);
        map.put("XIII", 13);
        map.put("XIV", 14);
        map.put("XV", 15);
        map.put("XVI", 16);
        map.put("XVII", 17);
        map.put("XVIII", 18);
        map.put("XIX", 19);
        map.put("XX", 20);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] array = str.split(" ");

        int x, y;

        if((x = test(array[0])) != 0 && (y = test(array[2])) != 0){
            int res = result(array[1], x, y);

            for(Map.Entry<String, Integer> pair : map.entrySet()){
                if(pair.getValue() == res){
                    System.out.println(pair.getKey());
                }
            }
        } else {
            x = Integer.parseInt(array[0]);
            y = Integer.parseInt(array[2]);
            System.out.println(result(array[1], x, y));
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
}
