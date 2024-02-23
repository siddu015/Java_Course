package LeetCode;
public class Diagnol {

    public static void main(String args[]) {
        int[][] matrix = {{1,2,3,4,5},{4,5,6},{7,8,9}};
        int[] diagnolArray = new int[9];
        int rowTemp =0, diagnolElement =0;
        for(int i=0; i<3; i++){
            for(int row=i,column = 0; column <= rowTemp; column++,row--){
                diagnolArray[diagnolElement++] = matrix[row][column];  
            }
            rowTemp++;
            if(i==2){
                rowTemp--;
                for(int row =i, column = 1; column <= rowTemp; row--, column++){
                    diagnolArray[diagnolElement++] = matrix[row][column]; 
                }
                diagnolArray[diagnolElement++] = matrix[2][2];
            }
        }
        for(int i: diagnolArray){
            System.out.print(i+" ");
        }


}

}
