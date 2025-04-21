class PatternDemo{
    public static void main(String[] args) {
        pattern1(8);
    }

    static void pattern1(int n){
        for (int i=1; i<=n; i++)
        {
            //for every row run the column
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            //when one row is printed we need to addd new line
            System.out.println();
        }
    }
}

