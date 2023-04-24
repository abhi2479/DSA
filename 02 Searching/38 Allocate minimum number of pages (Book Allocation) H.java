/* You are given N number of books. Every ith book has Ai number of pages. 
You have to allocate contiguous books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is the minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

 

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in 
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:32
Explanation: Allocation is done as
{15,17} and {20}
Your Task:
You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= A [ i ] <= 106
1 <= M <= 105 */


	
	
class Solution 
{
    
    public static int findPages(int[]A,int N,int M)
    {
        
        if(N<M)
        return -1;
        
        
        int sum = 0, max = Integer.MIN_VALUE, ans = -1;

        for (int num : A) {
            max = Math.max(max, num);
            sum += num;
        }
        
        if(N==M)
        return max;

        int start = max, end = sum, mid = 0;
        while (start <= end) {
            sum = 0;
            int div = 1;
            mid = (start + end) / 2;

            for (int j : A) {
                int temp=sum + j;
                if (temp <= mid) {
                    sum+=j;
                }
                else {
                    sum=j;
                    div++;
                }
            }

            if (div <= M) {
                ans = mid;
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return ans;

    
    }
};