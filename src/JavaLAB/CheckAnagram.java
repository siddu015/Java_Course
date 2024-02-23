package JavaLAB;

import java.util.HashMap;
import java.util.Scanner;

import java.util.Map;

public class CheckAnagram {
        public static void main(String args[])
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the first string: ");
            String str1 = scanner.nextLine();
            System.out.print("Enter the second string: ");
            String str2 = scanner.nextLine();

            str1 = str1.toLowerCase().replace(" ","");
            str2 = str2.toLowerCase().replace(" ","");
            
            var hmap1= new HashMap<Character,Integer>();
            var hmap2 = new HashMap<Character,Integer>();

            for (char ch : str1.toCharArray()) {
                 if (hmap1.get(ch) == null)
                    hmap1.put(ch, 1);
                 else {
                    int c = hmap1.get(ch);
                    hmap1.put(ch, ++c);
                }
            }

            for (char ch : str2.toCharArray()) {
                if (hmap2.get(ch) == null)
                    hmap2.put(ch, 1);
                else
                {
                    int d = hmap2.get(ch);
                    hmap2.put(ch, ++d);
                }
            }

            if (hmap1.equals(hmap2))
                System.out.println("The two strings are anagrams");
            else
                System.out.println("The two strings are NOT anagrams");
        }
}


