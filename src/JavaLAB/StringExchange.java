package JavaLAB;

import java.util.Scanner;

public class StringExchange{
    private String original, reverse;
    private final Scanner scanner = new Scanner(System.in);
    public StringExchange() {
        original = "";
        reverse = "";
    }

    public void readSentence() {
        System.out.print("Enter the sentence: ");
        original = scanner.nextLine();

        if(original.charAt(original.length() - 1) != '.')
            original += '.';
    }

    public void exchangeString() {
        String temp = "";
        for(char ch : original.toCharArray()) {
            if(ch != ' ' && ch != '.')
                temp += ch;
            else {
                int length = temp.length();
                for(int i = 0; i < length; i++){
                    if(i == 0)
                        ch = temp.charAt(length - 1);
                    else if (i == length - 1)
                        ch = temp.charAt(0);
                    else
                        ch = temp.charAt(i);

                    reverse += ch;
                }
                reverse += ' ';
                temp = "";
            }
        }
    }

    public void display(){
        System.out.println("The original sentence: "+original);
        System.out.println("The reversed String: "+reverse);
    }

    public static void main(String[] args) {
        var sentence = new StringExchange();
        sentence.readSentence();
        sentence.exchangeString();
        sentence.display();

    }



}