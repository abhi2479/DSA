17.      1
        212
       32123
      4321234
       32123
        212
         1
		 
		for(int i=1;i<=2*n-1;i++)
        {
            if(i<=n) {
                for (int j = 0; j < n - i; j++)
                    System.out.print(" ");
                for (int j = i; j >= 1; j--)
                    System.out.print(j);
                for (int j = 2; j <= i; j++)
                    System.out.print(j);
            }
            else
            {
                for (int j = 0; j < i-n; j++)
                    System.out.print(" ");
                for (int j = 2*n-i; j >= 1; j--)
                    System.out.print(j);
                for (int j = 2; j <= 2*n-i; j++)
                    System.out.print(j);
            }

            System.out.println();
        }