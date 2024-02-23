package JAVA.OOP;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;
    private final NumberFormat currency;
    
    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }
    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------"); 
        System.out.println("Monthly Payments: "+mortgageFormatted);
    }

    public void printPaymentShedule() {
        System.out.println();
        System.out.println("PAYMENT SHEDULE");
        System.out.println("---------------");
        
        for( double balance : calculator.getRemaningBalances()){
            System.out.println( currency.format(balance));
        }
    } 
    
    

}
