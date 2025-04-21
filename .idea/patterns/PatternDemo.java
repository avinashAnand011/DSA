class PatternDemo {
    public static void main(String[] args) {
        // pattern1(8);
        // pattern2(4);
        // pattern3(5);
        // pattern4(5);
        // pattern5(5);
        // pattern6(5);
        // pattern7(5);
        pattern8(4);
    }

    static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            // for every row run the column
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // when one row is printed we need to addd new line
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int i = 0; i < 2 * n; i++) {
            int totalColInRow = i > n ? 2 * n - i : i;
            for (int j = 0; j < totalColInRow; j++) {

                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int i = 0; i < 2 * n; i++) {
            int totalColInRow = i > n ? 2 * n - i : i;
            int noOfSpaces = n - totalColInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < totalColInRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            int noOfSpaces = n - i;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            for (int k = 2; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }

    }

    static void pattern7(int n) {
        for (int i = 1; i <= 2 * n; i++) {
            int c = i > n ? 2 * n - i : i;
            int noOfSpaces = n - c;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" " + " ");
            }
            for (int j = c; j >= 1; j--) {
                System.out.print(j + " ");
            }
            for (int k = 2; k <= c; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

    }

    static void pattern8(int n) {
        int orgN = n;
        n = 2 * n;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int atEveryIndex = orgN - Math.min(Math.min(i, j), Math.min(n - i, n - j));
                System.out.print(atEveryIndex);
            }
            System.out.println();
        }
    }

}
