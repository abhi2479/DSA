5.  *
    **
    ***
    ****
    *****
    ****
    ***
    **
    *
	
	for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print("*");
          System.out.println();
        }
        for(int i=1;i<=n-1;i++)
        {
            for(int j=1;j<=n-i;j++)
                System.out.print("*");
            System.out.println();
        }
		
	//===========================================
	
	for(int i=1;i<=2*n-1;i++)
        {
            if(i<=n)
                for(int j=1;j<=i;j++)
                    System.out.print("*");
            else {
                for(int j=1;j<=2*n-i;j++)
                    System.out.print("*");
            }
            System.out.println();
        }