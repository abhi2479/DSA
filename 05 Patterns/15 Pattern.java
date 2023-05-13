15.      *
        * *
       *   *
      *     *
     *       *
      *     *
       *   *
        * *
         *
		 
		for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");
            for(int j=1;j<=2*i-1;j++) {
                if(j==1 || j==2*i-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for(int j=1;j<=n-i;j++)
                System.out.print(" ");

            System.out.println();
        }
        for(int i=1;i<n;i++)  //changed i=1 from i=0 to cut the last of previous loop's print so it doesnt repeat
        {
            for(int j=1;j<=i;j++)
                System.out.print(" ");
            for(int j=0;j<=7-2*i+1;j++) {
                if(j==0 || j==8-2*i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
                System.out.print(" ");

            System.out.println();
        }