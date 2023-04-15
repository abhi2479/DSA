/* Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]

 

Constraints:

    1 <= n <= 20

 */
 
 class Solution {
    public int[][] generateMatrix(int n) {
        int sr=0,sc=0,er=n-1,ec=n-1;
        int i=1,j,dir=0;
        int[][] arr=new int[n][n];

        while(sc<=ec && sr<=er)
        {
            switch(dir)
            {
                case 0: 
                        for(j=sc;j<=ec;j++)
                            arr[sr][j]=i++;
                        sr++;
                        break;
                case 1: 
                        for(j=sr;j<=er;j++)
                            arr[j][ec]=i++;
                        ec--;
                        break;
                case 2: 
                        for(j=ec;j>=sc;j--)
                            arr[er][j]=i++;
                        er--;
                        break;
                case 3: 
                        for(j=er;j>=sr;j--)
                            arr[j][sc]=i++;
                        sc++;
                        break;
            }
            dir=(dir+1)%4;
        }
        return arr;
    }


}
