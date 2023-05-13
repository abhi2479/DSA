
9.  *********
     *******
      *****
       ***
        *
		
		for(int i=0;i<n;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(" ");

            for(int j=0;j<=7-2*i+1;j++)
                System.out.print("*");

            for(int j=1;j<=i;j++)
                System.out.print(" ");

            System.out.println();
        }