package JavaLAB;

import java.util.Scanner;

abstract class Bank {
    public double calculateEMI(double principal, int duration, double rateOfInterest) {
        double monthlyInterestRate = rateOfInterest / 1200;
        return (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -duration));
    }


}
class HDFC extends Bank {
}
class SBI extends Bank {
}
class IDFC extends Bank {
}

public class BankingApplication {
     public static void main(String[] args) {
         var scanner = new Scanner(System.in);

         System.out.print("Enter Principal Amount: INR");
         double principal = scanner.nextDouble();
         System.out.print("Enter Duration (in months): ");
         int duration = scanner.nextInt();
         System.out.print("Enter Rate Interest for HDFC (%): ");
         double rateOfInteresthdfc = scanner.nextDouble();
         System.out.print("Enter Rate Interest for SBI (%): ");
         double rateOfInterestsbi = scanner.nextDouble();
         System.out.print("Enter Rate Interest for IDFC (%): ");
         double rateOfInterestidfc = scanner.nextDouble();

         var hdfc = new HDFC();
         var sbi=new SBI();
         var idfc=new IDFC();
         double emihdfc = hdfc.calculateEMI(principal, duration, rateOfInteresthdfc);
         double emisbi = sbi.calculateEMI(principal, duration, rateOfInterestsbi);
         double emiidfc = idfc.calculateEMI(principal, duration, rateOfInterestidfc);
         System.out.printf("\nMonthly EMI (HDFC): INR => %.2f", emihdfc);
         System.out.printf("\nMonthly EMI (SBI): INR => %.2f", emisbi);
         System.out.printf("\nMonthly EMI (IDFC): INR => %.2f", emiidfc);

     }
}
