
10.      *
        * *
       * * *
      * * * *
     * * * * *
	 
	 static void pattern10 (int n)
    {
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");

            for(int j=1;j<=2*i-1;j++) {
                if(j%2==1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            for(int j=1;j<=n-i;j++)
                System.out.print(" ");

            System.out.println();
        }
    }