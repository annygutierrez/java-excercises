package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class covid19TestManager {
    public static void main(String[] args) {
        List<covid19Test> tests = new ArrayList<>();
        String testResult;
        int age;
        String gender;
        do {
            Scanner testResultInput = new Scanner(System.in);
            System.out.print("Enter the result of the COVID test. (P) Positive; (N) Negative; (X) Exit: ");
            testResult = testResultInput.nextLine();
            if (!testResult.equalsIgnoreCase("X")) {
                Scanner ageInput = new Scanner(System.in);
                System.out.print("Enter the age of the patient: ");
                age = ageInput.nextInt();
                Scanner genderInput = new Scanner(System.in);
                System.out.print("Enter the gender of the patient. (M) Male; (F) Female: ");
                gender = genderInput.nextLine();
                tests.add(new covid19Test(testResult, age, gender));
            }
        } while (!testResult.equalsIgnoreCase("X"));
        getAverageAges(tests);
        getOldInfectedFemales(tests);
        getPercentageTest(tests);
    }

    static void getAverageAges(List<covid19Test> tests) {
        List<Integer> positiveAges = new ArrayList<>();
        List<Integer> negativeAges = new ArrayList<>();
        double positiveAgeSum = 0;
        double negativeAgeSum = 0;
        double positiveAgeAverage;
        double negativeAgeAverage;
        for (covid19Test i : tests) {
            if (i.testResult.equalsIgnoreCase("P")) {
                positiveAgeSum = positiveAgeSum + i.age;
                positiveAges.add(i.age);
            } else if (i.testResult.equalsIgnoreCase("N")) {
                negativeAgeSum = negativeAgeSum + i.age;
                negativeAges.add(i.age);
            }
        }
        positiveAgeAverage = positiveAgeSum/positiveAges.size();
        negativeAgeAverage = negativeAgeSum/negativeAges.size();
        System.out.format("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+------+%n");
        System.out.println("People positive for COVID were around " + positiveAges + ", average age of " + String.format("%.2f",positiveAgeAverage) + ".");
        System.out.println("People negative for COVID were around " + negativeAges + ", average age of " + String.format("%.2f",negativeAgeAverage) + ".");
    }

    static void getOldInfectedFemales(List<covid19Test> tests) {
        List<Integer> positiveAges = new ArrayList<>();
        List<Integer> positiveTests = new ArrayList<>();
        double percentage;
        for (covid19Test i : tests) {
            if (i.genre.equalsIgnoreCase("F") && i.age > 50) {
                positiveAges.add(i.age);
                if (i.testResult.equalsIgnoreCase("P")) {
                    positiveTests.add(i.age);
                }
            }
        }
        percentage = (positiveAges.size() * 100.00)/tests.size();
        System.out.format("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+------+%n");
        System.out.println("Today " + tests.size() + " tests were done, from which " + positiveAges.size() + " were carried out on women over 50 years old, from these " + positiveAges.size() + " tests, " + positiveTests.size() + " were positive.");
        System.out.println("Total percentage of women over 50 who were positive for COVID 19: " + String.format("%.2f",percentage) + "%");
    }

    static void getPercentageTest(List<covid19Test> tests) {
        List<Integer> positiveTests = new ArrayList<>();
        List<Integer> negativeTests = new ArrayList<>();
        double positivePercentage;
        double negativePercentage;
        for (covid19Test i : tests) {
            if (i.testResult.equalsIgnoreCase("P")) {
                positiveTests.add(i.age);
            } else {
                negativeTests.add(i.age);
            }
        }
        positivePercentage = (positiveTests.size() * 100.00)/tests.size();
        negativePercentage = (negativeTests.size() * 100.00)/tests.size();
        System.out.format("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+------+%n");
        System.out.println("Total percentage of positive tests: " + String.format("%.2f",positivePercentage) + "%");
        System.out.println("Total percentage of negative tests: " + String.format("%.2f",negativePercentage) + "%");
    }
}
