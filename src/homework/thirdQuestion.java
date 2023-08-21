package homework;

import java.util.Scanner;

public class thirdQuestion {
    public static void main(String[] args) {
        double normalDiscount = 20;
        double creditCardDiscount = 20;
        double igv = 18;
        double igvPayed;
        double grossCost;
        double netCost;
        int paymentMethod; // debitCard = 0; creditCard = 1; cash = 2

        Scanner grossCostInput = new Scanner(System.in);
        System.out.print("Enter the gross cost. Note: IGV already contained in the tag price: ");
        grossCost = grossCostInput.nextDouble();

        Scanner paymentMethodInput = new Scanner(System.in);
        System.out.print("Enter the payment method - Debit card(0); Credit Card(1); Cash (2): ");
        paymentMethod = paymentMethodInput.nextInt();

        netCost = getNetCostOfPurchase(grossCost, normalDiscount, creditCardDiscount, paymentMethod);
        igvPayed = getIGVAmount(netCost, igv);
        System.out.println("Total amount to pay/Net price: " + netCost);
        System.out.println("Total amount payed as IGV/ Already included in the total amount: " + igvPayed);
    }

    static double getNetCostOfPurchase (double grossCost, double discount, double cardDiscount, int paymentMethod) {
        double firstDiscount = grossCost*discount/100;
        double secondDiscount = (grossCost - firstDiscount)*cardDiscount/100;
        return paymentMethod == 1 ? grossCost - firstDiscount - secondDiscount : grossCost - firstDiscount;
    }

    static double getIGVAmount (double amount, double igv) {
        return  amount*igv/100;
    }
}
