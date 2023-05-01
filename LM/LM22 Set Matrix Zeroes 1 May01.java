/* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's. You must do it in place.

Input Format

m = number of row. n = number of column. m following row of n element, space separated.

Constraints

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
Output Format

mxn size matrix.

Sample Input 0

3
3
1 1 1
1 0 1
1 1 1
Sample Output 0

1 0 1
0 0 0
1 0 1
Sample Input 1

3
4
0 1 2 0
3 4 5 2
1 3 1 5
Sample Output 1

0 0 0 0
0 4 5 0 
0 3 1 0

*/


public static List<List<Integer>> setZeroes(int m, int n, List<List<Integer>> mat) {
    // Write your code here
        
        boolean isR=false;
        boolean isC=false;
        
        for(int i=0;i<mat.size();i++)
            if(mat.get(i).get(0)==0)
                isR=true;
        
        for(int i=0;i<mat.get(0).size();i++)
            if(mat.get(0).get(i)==0)
                isC=true;
        
        for(int i=1;i<mat.size();i++)
            for(int j=1;j<mat.get(0).size();j++)
            {
                if(mat.get(i).get(j)==0)
                {
                    mat.get(i).set(0,0);
                    mat.get(0).set(j,0);
                }
            }
        
        for(int i=1;i<mat.size();i++)
            for(int j=1;j<mat.get(0).size();j++)
            {
                if(mat.get(i).get(0)==0 || mat.get(0).get(j)==0)
                {
                    mat.get(i).set(j,0);
                }
            }
        
        if(isC)
        {
            for(int i=0;i<mat.get(0).size();i++)
                mat.get(0).set(i,0);
        }
        
        if(isR)
        {
            for(int i=0;i<mat.size();i++)
                mat.get(i).set(0,0);
        }
        
        return mat;
    

    }