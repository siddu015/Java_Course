package LeetCode;

public class NumberOfWays {

    public static void main(String[] args) {
        String str = "SPSPPSSPSSSS";
        int seats=0;
        int numberOfWays=0;
        for(int i= 0; i < str.length() - 1; i++){
            if(str.charAt(i) == 'S' )
                seats++;
            if(seats == 2)
                numberOfWays++;
            if(i == str.length() - 2 && seats ==1 && str.charAt(str.length() - 1) == 'S' )
                numberOfWays++;               
        }
        System.out.println(numberOfWays);


    }

}
