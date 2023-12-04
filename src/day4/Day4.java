package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day4 {

    public static void main(String[] args) {
        
        int[] tabOfCards = new int[220];
        Arrays.fill(tabOfCards, 1);

        int currentCount = 0;
        int sum = 0;
        int points = 0;
        File file = new File("C:\\Users\\shadi\\IdeaProjects\\AoC-2023\\src\\day4\\input.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                for (int i = 0; i < tabOfCards[currentCount]; i++) {
                    sum = processString(line);
                    incrementArray(tabOfCards, currentCount, sum);
                    points++;

                }
                currentCount++;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(points);
    }

    public static int processString(String s) {

        int count = 0;

        String[] cardAndScores;
        cardAndScores = s.split(":");
        ArrayList<Integer> winningNumberList = new ArrayList<>();
        ArrayList<Integer> choosenNumberList = new ArrayList<>();


        String[] winningsAndChoosenNumbers;
        winningsAndChoosenNumbers = cardAndScores[1].split("\\|");

        System.out.println(cardAndScores[0]);

        //delete spaces from first and last position
        winningsAndChoosenNumbers[0] = winningsAndChoosenNumbers[0].substring(1, winningsAndChoosenNumbers[0].length());
        winningsAndChoosenNumbers[1] = winningsAndChoosenNumbers[1].substring(1, winningsAndChoosenNumbers[1].length());

        winningsAndChoosenNumbers[0] = winningsAndChoosenNumbers[0].replaceAll(" {2}", " ");
        winningsAndChoosenNumbers[1] = winningsAndChoosenNumbers[1].replaceAll(" {2}", " ");

        String winningsNumbersOnly[] = winningsAndChoosenNumbers[0].split(" ");
        String choosenNumbersOnly[] = winningsAndChoosenNumbers[1].split(" ");


        for (int i = 0; i < winningsNumbersOnly.length; i++) {
            if (winningsNumbersOnly[i].isEmpty()) {
                continue;
            }
            winningNumberList.add(Integer.parseInt(winningsNumbersOnly[i].replaceAll("[\\D]", "")));
        }

        System.out.println(winningNumberList);

        for (int i = 0; i < choosenNumbersOnly.length; i++) {
            if (choosenNumbersOnly[i].isEmpty()) {
                continue;
            }
            choosenNumberList.add(Integer.parseInt(choosenNumbersOnly[i].replaceAll("[\\D]", "")));
        }

        System.out.println(choosenNumberList);


        for (int i = 0; i < choosenNumbersOnly.length; i++) {


            if (choosenNumbersOnly[i].isEmpty()) {
                continue;
            }
            int temp = Integer.parseInt(choosenNumbersOnly[i].replaceAll("[\\D]", ""));
            if (winningNumberList.contains(temp)) {
                count++;
            }
        }

        return count;

//        if (count == 0) {
//            return 0;
//        } else {
//            System.out.println(count);
//            return (Math.pow(2, count - 1));
//        }
    }


    public static void incrementArray(int[] tabOfCards, int currentPosition, int count) {
        for (int i = 1; i <= count; i++) {

            if (currentPosition + i >= tabOfCards.length) {
                break;
            }

            tabOfCards[currentPosition + i]++;
        }
    }

}
