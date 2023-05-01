/* Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Input Format

You will be given matrix and size of the matrix

Constraints

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is 0 or 1.

Output Format

Return integer value

Sample Input 0

3
3
1 0 1 
1 1 0
1 1 1
Sample Output 0

4 

*/


int[][] aux = new int[m+1][n+1];
        int min=0,max=0;
        
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(arr.get(i-1).get(j-1)==1)
                {
                    min=Math.min(Math.min(aux[i-1][j-1],aux[i][j-1]),aux[i-1][j]);
                    aux[i][j]=min+1;
                    max=Math.max(max,aux[i][j]);
                }
            }
        }
        
        return max*max;