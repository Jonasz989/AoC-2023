package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.IntStream;

import static java.lang.Character.isDigit;

public class Day1 {
    public static void main(String[] args) {

        int sum = 0;
        File file = new File("input1.txt");

        int i = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Index: " + i++);
                System.out.println("Line: " + line);
                String replacedLine = replaceStringToInts(line);
                System.out.println("Replaced line: " + replacedLine);
                sum += processString(replacedLine);
                System.out.println("Suma: " + processString(replacedLine));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
    }

    public static int processString(String s) {


        char[] chars = s.toCharArray();
        int firstDigit = Character.getNumericValue(chars[0]);
        int secondDigit = Character.getNumericValue(chars[chars.length - 1]);

        return firstDigit * 10 + secondDigit;
    }

    public static String replaceStringToInts(String s) {
        s = s + "xxxxxxxxx";
        StringBuilder temp = new StringBuilder("");
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {

            if (isDigit(s.charAt(i))) {
                temp.append(s.charAt(i));
            }

            try {
                if (s.charAt(i) == 'o' && s.charAt(i + 1) == 'n' && s.charAt(i + 2) == 'e') {
                    temp.append(1);
                }
                if (s.charAt(i) == 't' && s.charAt(i + 1) == 'w' && s.charAt(i + 2) == 'o') {
                    temp.append(2);
                }

                if (s.charAt(i) == 't' && s.charAt(i + 1) == 'h' && s.charAt(i + 2) == 'r' && s.charAt(i + 3) == 'e') {
                    temp.append(3);
                }

                if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'o' && s.charAt(i + 2) == 'u' && s.charAt(i + 3) == 'r') {
                    temp.append(4);
                }

                if (s.charAt(i) == 'f' && s.charAt(i + 1) == 'i' && s.charAt(i + 2) == 'v' && s.charAt(i + 3) == 'e') {
                    temp.append(5);
                }

                if (s.charAt(i) == 's' && s.charAt(i + 1) == 'i' && s.charAt(i + 2) == 'x') {
                    temp.append(6);
                }

                if (s.charAt(i) == 's' && s.charAt(i + 1) == 'e' && s.charAt(i + 2) == 'v' && s.charAt(i + 3) == 'e' && s.charAt(i + 4) == 'n') {
                    temp.append(7);
                }

                if (s.charAt(i) == 'e' && s.charAt(i + 1) == 'i' && s.charAt(i + 2) == 'g' && s.charAt(i + 3) == 'h' && s.charAt(i + 4) == 't') {
                    temp.append(8);

                }
                if (s.charAt(i) == 'n' && s.charAt(i + 1) == 'i' && s.charAt(i + 2) == 'n' && s.charAt(i + 3) == 'e') {
                    temp.append(9);
                }

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("StringIndexOutOfBoundsException");
            }
        }

        return temp.toString();
    }
}
