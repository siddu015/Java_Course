package JavaLAB;

import java.util.*;



public class DecimalToBinary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first Decimal Number: ");
            int decimal1 = sc.nextInt();

        System.out.print("Enter the second Decimal Number: ");
            int decimal2 = sc.nextInt();

        String binary1 = decimalToBinary(decimal1);
        String binary2 = decimalToBinary(decimal2);

        System.out.println(addBinary(binary1, binary2));


    }

    public static String decimalToBinary(int decimalValue){
        StringBuilder binaryValue = new StringBuilder();
        while(true){
            int remainder = decimalValue%2;
            binaryValue.insert(0, remainder);
            decimalValue=decimalValue/2;
            if(decimalValue==0) break;
        }
        return binaryValue.toString();
    }

    public static String addBinary(String binary1, String binary2){
        StringBuilder binaryAdded = new StringBuilder();

        int carry =0;
        int length1 = binary1.length() - 1;
        int length2 = binary2.length() - 1;

        while(length1>=0 || length2>=0 || carry>0){

            int digit1 = length1>=0 ? binary1.charAt(length1--)-'0': 0;
            int digit2 = length2>=0 ? binary2.charAt(length2--)-'0': 0;

            int sum = digit1 + digit2 + carry;
            
            binaryAdded.insert(0, sum%2);
            carry = sum/2;
            
        }
        return binaryAdded.toString();   
   
    }
}








 

