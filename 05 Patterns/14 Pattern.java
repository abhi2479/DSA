
14.  *********
      *     *
       *   *
        * *
         *
		 
		 for(int i=0;i<n;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(" ");

            for(int j=0;j<=7-2*i+1;j++) {
                if(j==0 || j==8-2*i || i==0)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
                System.out.print(" ");

            System.out.println();
        }