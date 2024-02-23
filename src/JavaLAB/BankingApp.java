package JavaLAB;

import java.util.Scanner;
class BankDetails {
    String accNo, name, accType;
    long balance;
    final Scanner sc = new Scanner(System.in);

    public void openAccount(){
        System.out.println("Enter Account NO:");
        accNo = sc.next();
        System.out.println("Enter Account type:");
        accType = sc.next();
        System.out.println("Enter Name:");
        name = sc.next();
        System.out.println("Enter Balance:");
        balance = sc.nextLong();

    }

    public void showAccount(){
        System.out.println("Account NO:" + accNo);
        System.out.println("Name:" + name);
        System.out.println("Account type:" + accType);
        System.out.println("Balance:" + balance);
    }

    public void deposit(){
        System.out.print("Enter the amount you want to deposit:");
        long amt = sc.nextLong();
        balance += amt;
    }

    public void withdraw(){
        System.out.print("Enter the amount you want to withdraw:");
        long amt = sc.nextLong();
        if(balance >= amt){
            balance -= amt;
            System.out.println("Your balance after withdraw:"+balance);
        }
        else
            System.out.println("Your balance is less than amount \t Transaction failed!...");
    }
    public boolean search(String acc_no){
        if(accNo.equals(acc_no)){
            showAccount();
            return true;
        }
        return false;
    }
}

public class BankingApp {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("How many accounts you wanna open:");
        int n = sc.nextInt();
        BankDetails c[] = new BankDetails[n];
        for(int i=0; i<n; i++){
            c[i] = new BankDetails();
            c[i].openAccount();
        }
        int ch;
        do{
            System.out.println("1: For every customer details \n2: To search a account \n3: Deposit money \n4: Withdraw money\n 5: exit");
            System.out.println("Enter your choice");
            ch = sc.nextInt();
            switch (ch){
                case 1:
                    for(var bank : c)
                        bank.showAccount();
                    break;

                case 2:
                    System.out.println("Enter account no:");
                    String acc_no = sc.next();
                    boolean found = false;
                    for(var bank : c){
                        found = bank.search(acc_no);
                        if(found)
                            break;
                    }
                    if(!found)
                        System.out.println("Account not found");
                    break;

                case 3:
                    System.out.println("Enter account no:");
                    acc_no = sc.next();
                    found = false;
                    for(var bank : c){
                        found = bank.search(acc_no);
                        if(found) {
                            bank.deposit();
                            break;
                        }
                    }
                    if(!found)
                        System.out.println("Account not found");
                    break;

                case 4:
                    System.out.println("Enter account no:");
                    acc_no = sc.next();
                    found = false;
                    for(var bank : c){
                        found = bank.search(acc_no);
                        if(found) {
                            bank.withdraw();
                            break;
                        }
                    }
                    if(!found)
                        System.out.println("Account not found");
                    break;

                case 5:
                    System.out.println("see you soon:");
                    break;
            }
        }while (ch != 5);
    }
}