/* Given an m x n matrix, return all elements of the matrix in spiral order.

Input Format

M N 2D matrix of size M x N

Constraints

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
Output Format

1D matrix of size M*N

Sample Input 0

2
2
1 2
3 4
Sample Output 0

1 2 4 3
Sample Input 1

3
3
1 2 3
4 5 6
7 8 9
Sample Output 1

1 2 3 6 9 8 7 4 5 */

int rowS=0;
        int colS=0;
        int rowE=mat.size()-1;
        int colE=mat.get(0).size()-1;
        int dir=0;
        List<Integer> res= new ArrayList<>();
        
        while(rowS<=rowE && colS<=colE)
        {
            switch(dir)
            {
                case 0 : 
                    for(int i=colS;i<=colE;i++)
                            res.add(mat.get(rowS).get(i));
                    rowS++;
                    break;
                
                case 1 :
                    for(int i=rowS;i<=rowE;i++)
                            res.add(mat.get(i).get(colE));
                    colE--;
                    
                case 2 :
                    for(int i=colE;i>=colS;i--)
                            res.add(mat.get(rowE).get(i));
                    rowE--;
                case 3 : 
                    for(int i=rowE; i>=rowS;i--)
                        res.add(mat.get(i).get(colS));
                    colS++;
                    
            }
            dir=(dir+1)%4;
        }
        
        return res;

    }
