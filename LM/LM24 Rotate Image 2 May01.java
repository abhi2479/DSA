/* You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input Format

N 2D array of size NxN

Constraints

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
Output Format

2D array of size NxN

Sample Input 0

4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output 0

13 9 5 1
14 10 6 2
15 11 7 3
16 12 8 4 */

public static List<List<Integer>> rotate(List<List<Integer>> mat, int n) {
    // Write your code here
        List<Integer> temp =new ArrayList<>();
        int i=0,j=n-1;
        while(i<j)
        {
            temp=mat.get(i);
            mat.set(i,mat.get(j));
            mat.set(j,temp);
            
            i++;
            j--;
        }
        
        
        
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                int t=mat.get(i).get(j);
                mat.get(i).set(j,mat.get(j).get(i));
                mat.get(j).set(i,t);
            }
        }
        
        return mat;
        

    }