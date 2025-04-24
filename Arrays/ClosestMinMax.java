package DSA.Arrays;

public class ClosestMinMax {
    public static void main(String[] args) {
        int [] A ={2,6,1,6,9};
        solve(A);
    }

    public static  int solve(int[] A) {
        int size = A.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i=0;  i<size ; i++){
            max = Math.max(max,A[i]);
            min = Math.min(min,A[i]);
        }

        if (min== max){
            return 1;
        }

        int ans=size, maxIndex=-1, minIndex=-1;

        for( int j=size-1; j>=0; j--){
            if(A[j]==min){
                minIndex=j;
                if(maxIndex!=-1){
                    ans=Math.min(ans,(maxIndex-minIndex)+1);
                }
            }

             if(A[j]==max){
                maxIndex=j;
                if(minIndex!=-1){
                    ans=Math.min(ans,(minIndex-maxIndex)+1);
                }
            }

        }
        return ans;
    }
    }


