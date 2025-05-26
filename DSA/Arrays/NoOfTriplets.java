package DSA.Arrays;

public class NoOfTriplets {
    public static void main(String[] args) {

    }

    public static int solve(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int countLeftLess = 0;
            int countRightMore = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    countLeftLess++;
                }
            }

            for (int j = i + 1; j <= A.length; j++) {
                if (A[j] > A[i]) {
                    countRightMore++;
                }
            }
            ans+=countLeftLess*countRightMore;
        }
        return ans;

    }
}
