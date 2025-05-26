package DSA.Arrays;

public class LongestConsOnes {
    public static void main(String[] args) {

    }

    public static int solve(String A) {
        int size = A.length();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (A.charAt(i) == '1') {
                count++;
            }
        }

        if (count == 0) {
            return 0;
        } else {
            if (count == size) {
                return size;
            }
        }

        for (int j = 0; j < size; j++) {
            int leftCount = 0;
            int rightCount = 0;

            if (A.charAt(j) == '0') {
                for (int leftIndex = j - 1; leftIndex >= 0; leftIndex--) {
                    if (A.charAt(leftIndex) == '1') {
                        leftCount++;
                    } else {
                        break;
                    }

                }

                for (int rightIndex = j + 1; rightIndex < size; rightIndex++) {
                    if (A.charAt(rightIndex) == '1') {
                        rightCount++;
                    } else {
                        break;
                    }
                }

                ans = Math.max(ans, leftCount + rightCount);

            }

        }

        if (ans == count) {
            return ans;
        } else {
            return ans + 1;
        }

    }
}
