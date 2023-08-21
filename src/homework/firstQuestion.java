package homework;

import java.util.Scanner;

public class firstQuestion {
    public static void main(String[] args) {
        double operationResult;
        double salePrice = 3.71;
        double purchasePrice = 3.70;
        double ammount;
        int operation; // sell = 0; buy = 1;
        Scanner inputOperation = new Scanner(System.in);
        System.out.print("Enter the operation you want to make (0)sell ; (1)Buy: ");
        operation = inputOperation.nextInt();
        Scanner inputAmmount = new Scanner(System.in);
        System.out.print(
                (operation == 1 ? "Purchase" : "Sale") + " price -> " + (operation == 1 ? purchasePrice : salePrice) + ". Enter an amount of money: "
        );
        ammount = inputAmmount.nextDouble();
        if (operation == 0) {
            operationResult = sellDollars(ammount, salePrice);
        } else {
            operationResult = buyDollars(ammount, purchasePrice);
        }
        System.out.printf("Operation result: %.2f", operationResult);
    }

    static double buyDollars (double soles, double purchasePrice) {
       if (soles < purchasePrice)  return 0;
       return soles/purchasePrice;
    }

    static double sellDollars (double dollars, double salePrice) {
        return dollars*salePrice;
    }
}
