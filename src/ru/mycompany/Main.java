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

                for (Map.Entry<String, Integer> pair : map.entrySet()) {
                    if (pair.getValue() == res) {
                        System.out.println(pair.getKey());
                    }
                }
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
}
