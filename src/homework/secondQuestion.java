package homework;

import java.util.Scanner;

public class secondQuestion {
    public static void main(String[] args) {
        int totalRespondents;
        int acceptableRespondents;
        double acceptanceRate;
        Scanner totalInput = new Scanner(System.in);
        System.out.print("Enter the ammount of respondents: ");
        totalRespondents = totalInput.nextInt();
        Scanner acceptantsInput = new Scanner(System.in);
        System.out.print("Enter the number of people who totally approved the company: ");
        acceptableRespondents = acceptantsInput.nextInt();
        acceptanceRate = getRateOfApproval(totalRespondents, acceptableRespondents);
        System.out.printf("Percentage of acceptance of the company's service: %.2f", acceptanceRate);
    }

    static int getRateOfApproval(int totalRespondents, int acceptableRespondents) {
        return acceptableRespondents * 100/totalRespondents;
    }
}
