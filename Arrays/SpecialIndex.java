package DSA.Arrays;

public class SpecialIndex {
    public static void main(String[] args) {

    }

    public static int solve(int[] A) {

        int n = A.length;
        int[] ps = new int[n];
        int[] pse = new int[n];
        int[] pso = new int[n];

        pse[0] = A[0];
        pso[0] = 0;

        for (int i = 1; i < n; i++) {

            if (i % 2 == 1) {
                pse[i] = pse[i - 1];
                pso[i] = pso[i - 1] + A[i];
            } else {
                pse[i] = pse[i - 1] + A[i];
                pso[i] = pso[i - 1];
            }

        }

        int se, so, count = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                se = pse[i - 1] + pso[n - 1] - pso[i];
                so = pso[i - 1] + pse[n - 1] - pso[i];
            } else {
                so= pse[n-1]-pse[0];
                se=pso[n-1]-pso[0];
            }
            if(so==se){
                count++;
            }
        }

        return count;

    }

}
