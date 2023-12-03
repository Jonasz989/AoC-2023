package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Character.isDigit;

public class Day3 {

    public static Map<Integer, Integer[]> asteriskMap = new HashMap<>();

    public static ArrayList<Character> list = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(isDigit(0));

        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        list.add('0');
        list.add('.');


        int sum = 0;
        File file = new File("C:\\Users\\shadi\\IdeaProjects\\AoC-2023\\src\\day3\\input.txt");
        int i = 0;

        String[] map = new String[140];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = br.readLine()) != null) {
                map[i] = line;
                i++;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        findAsterisk(map);

        for (Map.Entry<Integer, Integer[]> entry : asteriskMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()[0] + " " + entry.getValue()[1]);

        }

    }


    public static void printMap(String[] map) {
        for (String s : map) {
            System.out.println(s);
        }
    }

    public static void findAsterisk(String[] map) {
        int ID = 0;
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length(); j++) {

                if (map[i].charAt(j) == '*') {
                    asteriskMap.put(ID, new Integer[]{i, j});
                    ID++;
                }

            }
        }
    }

    public static void findNumbersCoordinates(String[] map) {
        int ID = 0;
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length(); j++) {

                if (isDigit(map[i].charAt(j))) {
                    asteriskMap.put(ID, new Integer[]{i, j});

                    ID++;
                }

                if (j == 0) {
                    if (currentNumber.length() > 0) {
                        int number = Integer.parseInt(currentNumber.toString());
                        System.out.println("Liczba: " + number);
                    }
                    currentNumber = new StringBuilder();
                    System.out.println(currentNumber.length());
                }

                if (isDigit(map[i].charAt(j))) {
                    currentNumber.append(map[i].charAt(j));

                } else {
                    if (currentNumber.length() > 0) {
                        int number = Integer.parseInt(currentNumber.toString());

                        currentNumber = new StringBuilder();
                        System.out.println(currentNumber.length());
                    }
                }

            }
        }
    }

    public static int processMap(String[] map) {
        int sum = 0;
        boolean isSymbol = false;
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[i].length(); j++) {

                if (j == 0) {
                    if (isSymbol) {

                        if (currentNumber.length() > 0) {
                            int number = Integer.parseInt(currentNumber.toString());
                            System.out.println("dupa");
                            System.out.println("Liczba: " + number);
                            System.out.println("Suma przed: " + sum);
                            sum += number;
                            System.out.println("Suma po: " + sum);

                            isSymbol = false;
                        }
                    }


                    currentNumber = new StringBuilder();
                    System.out.println(currentNumber.length());
                }

                if (isDigit(map[i].charAt(j))) {
                    currentNumber.append(map[i].charAt(j));
                    if (checkSorrounding(i, j, map)) {
                        isSymbol = true;
                    }
                } else {
                    if (currentNumber.length() > 0) {
                        int number = Integer.parseInt(currentNumber.toString());

                        if (isSymbol) {
                            System.out.println("dupa");
                            System.out.println("Liczba: " + number);
                            System.out.println("Suma przed: " + sum);
                            sum += number;
                            System.out.println("Suma po: " + sum);

                            isSymbol = false;
                        }


                        currentNumber = new StringBuilder();
                        System.out.println(currentNumber.length());
                    }
                }
            }
        }

        if (isSymbol) {
            int number = Integer.parseInt(currentNumber.toString());
            sum += number;
        }

        return sum;
    }

    public static boolean checkSorrounding(int i, int j, String[] map) {

        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {

                if ((i + k) >= 0 && (j + l) >= 0 && (i + k) < map.length && (j + l) < map[i].length()) {
                    if (!list.contains(map[i + k].charAt(j + l))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean checkAsteriskSorrounding(int i, int j, String[] map) {

        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {

                if ((i + k) >= 0 && (j + l) >= 0 && (i + k) < map.length && (j + l) < map[i].length()) {
                    if (isDigit(map[i + k].charAt(j + l))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void countSymbols(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        Iterator iterator = set.iterator();

        System.out.println(set.size());
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }

}
