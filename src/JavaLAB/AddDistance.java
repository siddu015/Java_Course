package JavaLAB;


import java.util.Scanner;

public class AddDistance {
    private int feet,inches;

    public void Read(){
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter distance in Feet : ");
            feet = s.nextInt();
            System.out.print("Enter distance in Inches : ");
             inches = s.nextInt();
        }
             
    }
    public void Display(){
        System.out.println(feet +"feet "+inches+" inches");
    }
    public void Addition(AddDistance D1 , AddDistance D2){
        inches = D1.inches + D2.inches;
        feet = D1.feet + D2.feet + (inches / 12);
        inches = inches % 12;
    }
    public static void main(String[] args){
        while(true){
            System.out.println("Enter the option 1/0: 1: for continue , 0: for exit ");    
            try (Scanner s = new Scanner(System.in)) {
                int val = s.nextInt();
                switch(val){
                    case 1: 
                    var D1 = new AddDistance();
                    var D2 = new AddDistance();
                    var D3 = new AddDistance();
                    System.out.println("Enter 1 Distance :");
                    D1.Read();
                    System.out.println("Enter 2 Distance");
                    D2.Read();

                    D3.Addition(D1,D2);
                    System.out.println("Total Distance is");
                    D3.Display();
                    break;

                    case 0: System.exit(0);

                    default : System.out.println("Enter correct Input 1/0");
                }
            }
        }
    }
}

