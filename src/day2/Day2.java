package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    final static int RED_CUBES = 12;
    final static int GREEN_CUBES = 13;
    final static int BLUE_CUBES = 14;

    final static String RED = "red";
    final static String GREEN = "green";
    final static String BLUE = "blue";

    public static void main(String[] args) {

        int sum = 0;
        File file = new File("input.txt");


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += processStringSecondTask(line);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
    }

    public static int processString(String s) {
        boolean isFine = true;
        String[] temp;
        temp = s.split(":");

        String[] rounds;

        rounds = temp[1].split(";");

        for (int i = 0; i < rounds.length; i++) {

            System.out.println("TEMP2: " + rounds[i]);

            String[] singleRound;

            singleRound = rounds[i].split(",");

            for (int j = 0; j < singleRound.length; j++) {
                String[] singleCube;
                singleCube = singleRound[j].split(" ");


                if (singleCube[2].equals(RED)) {
                    if (Integer.parseInt(singleCube[1]) > RED_CUBES) {
                        isFine = false;
                    }
                } else if (singleCube[2].equals(GREEN)) {
                    if (Integer.parseInt(singleCube[1]) > GREEN_CUBES) {
                        isFine = false;
                    }
                } else if (singleCube[2].equals(BLUE)) {
                    if (Integer.parseInt(singleCube[1]) > BLUE_CUBES) {
                        isFine = false;
                    }
                } else {
                    System.out.println("ERROR");
                }
            }
        }

        if (isFine) {
            return Integer.parseInt(temp[0].replaceAll("[\\D]", ""));
        } else {
            return 0;
        }
    }

    public static int processStringSecondTask(String s) {

        int minimumForRed = 0;
        int minimumForGreen = 0;
        int minimumForBlue = 0;

        String[] temp;
        temp = s.split(":");

        String[] rounds;

        rounds = temp[1].split(";");

        for (int i = 0; i < rounds.length; i++) {
            String[] singleRound;

            singleRound = rounds[i].split(",");

            for (int j = 0; j < singleRound.length; j++) {
                String[] singleCube;
                singleCube = singleRound[j].split(" ");


                if (singleCube[2].equals(RED)) {
                    minimumForRed = Math.max(minimumForRed, Integer.parseInt(singleCube[1]));
                } else if (singleCube[2].equals(GREEN)) {
                    minimumForGreen = Math.max(minimumForGreen, Integer.parseInt(singleCube[1]));
                } else if (singleCube[2].equals(BLUE)) {
                    minimumForBlue = Math.max(minimumForBlue, Integer.parseInt(singleCube[1]));
                } else {
                    System.out.println("ERROR");
                }
            }
        }

        return (minimumForBlue * minimumForGreen * minimumForRed);
    }


}
