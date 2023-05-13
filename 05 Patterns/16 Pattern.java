16.           1
            1   1
          1   2   1
        1   3   3   1
      1   4   6   4   1
	  
	  
	  int i,j, space;
        int val=1;

        for(i=0; i<n; i++)
        {
            for(space=1; space <= n-i; space++)
                System.out.print(" ") ;

            for(j=0; j <= i; j++)
            {
                if (j==0 || i==0)
                    val = 1;
                else
                    val = val*(i-j+1)/j;

                System.out.print(val + " ");
            }
            System.out.println();
        }
	  
	  