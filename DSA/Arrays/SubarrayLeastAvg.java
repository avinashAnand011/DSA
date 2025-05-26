package DSA.Arrays;

public class SubarrayLeastAvg {

    public static void main(String[] args) {

    }

    public static int solve(int[] A, int B) {

        int size = A.length;
        int sum=0;
        int endIndex=B;
        int startIndex=0;
        
        

        if (B == size) {
            return 0;
        }

        for (int i = 0; i < size; i++) {
            sum = sum + A[i];
        }
        int leastSum=sum;
        int ansIndex=0;

        while(endIndex<size){
            sum = sum + A[endIndex]-A[startIndex];
            if(sum<leastSum){
                ansIndex=startIndex+1;
                leastSum=sum ; 
                }
                endIndex++; startIndex++;

        }

        return ansIndex;
    }

}
