/* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Input Format

You will be given matrix of 0's and 1's

Constraints

1 <= len(grid), len(grid[0]) <= 300
grid[i][j] is '0' or '1'.

Output Format

Return the number of Island

Sample Input 0

5
4
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0
Sample Output 0

1

 */


public static int countIsland(int n, int m, List<List<Integer>> isl) {
    // Write your code here
        
        int numI=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isl.get(i).get(j)==1)
                {
                    getIsland(isl,i,j,m,n);
                    numI++;
                }
            }
        }
        
        return numI;

    }
    
    private static void getIsland(List<List<Integer>> isl,int x,int y,int rowSize ,int colSize)
    {
        if(x<0 || y<0 || x>=rowSize || y>=colSize || isl.get(x).get(y)==0 )
            return;
        
        isl.get(x).set(y,0);
        
        getIsland(isl,x-1,y,rowSize,colSize);
        getIsland(isl,x,y+1,rowSize,colSize);
        getIsland(isl,x+1,y,rowSize,colSize);
        getIsland(isl,x,y-1,rowSize,colSize);
        
        
    }
