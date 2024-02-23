package JAVA.OOP;

public class MortgageCalculator {
    private int principle;
    private float annualInterest;
    private byte years;

    private final static byte PERCENT = 100;
    private final static byte MONTHS_IN_YEAR = 12;

    public MortgageCalculator(int principle, float annualInterest, byte years){
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.years = years; 
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();
    
        double mortgage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    
        return mortgage;
    }    

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();
        
        double balance = principle 
                    * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    
        return balance;              
    }
    
    public double[] getRemaningBalances(){
        var balances = new double[getNumberOfPayments()];
        for(short MONTH = 1; MONTH <= getNumberOfPayments(); MONTH++)
            balances[MONTH - 1] =  calculateBalance(MONTH);
        
        return balances;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short)(years * MONTHS_IN_YEAR);
    }

} 
