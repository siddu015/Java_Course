package JavaLAB;

import java.util.Scanner;




class Balance extends Exception{
    private final String message;

    Balance(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}


public class UserDefinedException {

    static double amount;
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the deposit Amount: ");
        amount = scanner.nextInt();
        System.out.print("Enter Withdraw Amount: ");
        double withdrawAmount = scanner.nextInt();
        try{
            if(amount <  withdrawAmount)
                throw new Balance("Insufficient balance! your balance is " + amount);
            else{
                System.out.println("Please Take The Money: " + withdrawAmount);
                amount -= withdrawAmount;
                System.out.println("Balance Available After withdraw : " + amount);
            }

        }
        catch (Balance msg) {
            msg.printStackTrace();
        }
    }

}
