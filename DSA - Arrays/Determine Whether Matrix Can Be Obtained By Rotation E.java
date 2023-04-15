/* Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

 

Example 1:


Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
Example 2:


Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.
Example 3:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 

Constraints:

n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1. */


class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; ++i) { // rotate 0, 1, 2, 3 times.
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }
    private void rotate(int[][] mat) {
        for (int i = 0, j = mat.length - 1; i < j; ++i, --j) { // reverse rows order.
            int[] tmp = mat[i];
            mat[i] = mat[j];
            mat[j] = tmp;
        } 
        for (int r = 0, R = mat.length; r < R; ++r) { // transpose.
            for (int c = r + 1; c < R; ++c) {
                int tmp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = tmp;
            }
        }
    }
}

//============================================================================================================

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        Ak ak=new Ak();
        boolean flag=false;
        int count=0;
        while(count<4)
        {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            ak.rotate(mat);
            count++;
        }
        return flag;
    }

}

    class Ak
    {
        public void rotate(int[][] mat)
        {
            int left,right,temp;
            int n=mat.length;
            for(int i=0;i<mat.length;i++)
            {
                left=0;
                right=mat.length-1;
                while(left<right)
                {
                    temp=mat[i][left];
                    mat[i][left]=mat[i][right];
                    mat[i][right]=temp;
                    left++;
                    right--;
                }
            }

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    temp=mat[i][j];
                    mat[i][j]=mat[j][i];
                    mat[j][i]=temp;
                }
            }   
        }
    }
	
	// Needs some checking 