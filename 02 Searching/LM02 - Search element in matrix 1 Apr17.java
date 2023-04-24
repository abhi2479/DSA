/* Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.

Input Format

N M 2D array integer of size NxM X target element

Constraints

1 <= N, M <= 1005
1 <= mat[][] <= 10000000
1<= X <= 10000000
Output Format

Integer 0/1, if element is present

Sample Input 0

3
3
1 2 3
4 5 6
7 8 9
5
Sample Output 0

1
Sample Input 1

2
2
1 5
3 9
7
Sample Output 1

0 */


int rlen=matrix.get(0).size();
        int row=0,col= rlen-1;
        while(row <= rlen-1 && col>=0)
        {
            if(matrix.get(row).get(col)==x)
                return 1;
            if(matrix.get(row).get(col)>x)
                col--;
            else
                row++;
        }
        
        return 0;