package LeetCode;

public class LargestGoodInteger{
    public  String largestGoodInteger(String num) {
        String good = "";
        for(int i = 0; i < num.length() - 2; i++){

            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2))
                if(num.substring(i, i+3).compareTo(good) > 0)
                    good = num.substring(i, i+3);

        }
        return  good;
    }

}
