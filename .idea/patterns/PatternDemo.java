class PatternDemo {
    public static void main(String[] args) {
        // System.out.println("1.\n");
        // pattern1(4);
        // System.out.println("2.\n");
        // pattern2(4);
        // System.out.println("3.\n");
        // pattern3(4);
        // System.out.println("4.\n");
        // pattern4(5);
        // System.out.println("5.\n");
        // pattern5(5);
        // System.out.println("6.\n");
        // pattern6(4);
        // System.out.println("7.\n");
        // pattern7(4);
        // System.out.println("8.\n");
        // pattern8(9);
        System.out.println("9.\n");
        pattern9(9);
        // System.out.println("28.\n");
        // pattern28(5);
        // System.out.println("30.\n");
        // pattern30(4);
        // System.out.println("17.\n");
        // pattern17(4);
        // System.out.println("31.\n");
        // pattern31(4);
    }

    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            // for every row run the column
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // when one row is printed we need to addd new line
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int i = 0; i < 2 * n; i++) {
            int totalColInRow = i > n ? 2 * n - i : i;
            for (int j = 0; j < totalColInRow; j++) {

                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            int totalNoOfSpaces = n - i;
            for (int s = 0; s < totalNoOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            int totalNoOfSpaces = i + 1;
            for (int s = 0; s < totalNoOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern8(int n) {
        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int s = 0; s < n - i; s++) {
                System.out.print(" ");
            }
            // Print asterisks
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }
    }

    static void pattern9(int n) {
        for (int i = 0; i < n; i++) {
            int noOfSpaces = i;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n-i*2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
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

    static void pattern30(int n) {
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

    static void pattern17(int n) {
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

    static void pattern31(int n) {
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
