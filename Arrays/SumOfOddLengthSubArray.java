package DSA.Arrays;

class SumOfOddLengthSubArray {
public static void main(String[] args) {
}

public int sumOddLengthSubArrays(int[] nums){
    int n = nums.length;
    int sum=0;

    for(int i =0; i<n ; i++){
        int leftCount =i+1;
        int rightCount=n-i;
        int totalCount = leftCount*rightCount;
        int addCount=(totalCount+1)/2;
        sum+=nums[i]*addCount;
    }

    return sum;
}
    
}