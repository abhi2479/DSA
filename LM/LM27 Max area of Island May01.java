/* You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Input Format

You will be given the matrix and size of the matrix

Constraints

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1

Output Format

Return the Integer area value

Sample Input 0

3
3
0 0 0
1 0 1
1 0 0
Sample Output 0

2 
*/

 public static int max_area(int m, int n, List<List<Integer>> isl) {
    // Write your code here
        
         int max=0;
        int[] area = new int[1];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isl.get(i).get(j)==1)
                {
                    area[0]=0;
                    getIsland(isl,i,j,m,n,area);
                    max=Math.max(area[0],max);
                }
            }
        }
        
        return max;

    }
    
    private static void getIsland(List<List<Integer>> isl,int x,int y,int rowSize ,int colSize,int[] area)
    {
        if(x<0 || y<0 || x>=rowSize || y>=colSize || isl.get(x).get(y)==0 )
            return;
        
        area[0]++;
        isl.get(x).set(y,0);
        
        getIsland(isl,x-1,y,rowSize,colSize,area);
        getIsland(isl,x,y+1,rowSize,colSize,area);
        getIsland(isl,x+1,y,rowSize,colSize,area);
        getIsland(isl,x,y-1,rowSize,colSize,area);
        
        
    }

}

