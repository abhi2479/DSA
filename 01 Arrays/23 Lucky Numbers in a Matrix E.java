/* Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct. */


public List<Integer> luckyNumbers (int[][] matrix) {
    int small, big;
    List<Integer> list = new ArrayList<Integer>();
    for(int itr = 0; itr < matrix.length; itr++){
        int ktr = 0;
        small = 999999;             
        for(int jtr = 0; jtr < matrix[0].length; jtr++){                
            if(small > matrix[itr][jtr]){
                small = matrix[itr][jtr];
                ktr = jtr;
            }
        }
        big = small;
        for(int jtr = 0; jtr < matrix.length; jtr++){
            big = Math.max(big, matrix[jtr][ktr]);
        }
        if(small == big) {
            list.add(small);
        }
    }
    return list;
}

//==========================================================================================================================


   public List<Integer> luckyNumbers (int[][] matrix) {
        
        int[] minMatrixEachRow = new int[matrix.length];
        int[] maxMatrixEachColumn = new int[matrix[0].length];
        
        
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        
         //Finding min element of  each row and storing in an array
        for(int i=0; i< matrix.length;i++)
        {
               minElement = Integer.MAX_VALUE ;
            for(int j=0; j< matrix[0].length; j++){
                if(matrix[i][j]< minElement)
                {
                    minElement = matrix[i][j];
                }
            }
            minMatrixEachRow[i] = minElement ;
        }
        
         //Finding max element of each column and storing in an array
        for(int i=0; i< matrix[0].length;i++)
        {
            maxElement = Integer.MIN_VALUE ;  
            
            for(int j=0; j< matrix.length; j++){
                if(matrix[j][i]> maxElement)
                {
                    maxElement = matrix[j][i];
                }
            }
            maxMatrixEachColumn[i] = maxElement ;
        }
        
        
        
     //Initializing an ArrayList
        List<Integer> ans = new ArrayList<>();
        
        //Iterating through
        for(int i=0; i< minMatrixEachRow.length ; i++){
            for(int j=0; j< maxMatrixEachColumn.length ;j++)
            {
             if(minMatrixEachRow[i] == maxMatrixEachColumn[j]){
                 ans.add(minMatrixEachRow[i]);
             }   
            } 
        }
        
        return ans;
                
     
    }

 