/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Input Format

First line is the length of the array
Second line is the elements of the array

Constraints

1 <= arr.length <= 3 * 104
-100 <= arr[i] <= 100
arr is sorted in non-decreasing order.

Output Format

Return length of array after removing duplicates

Sample Input 0

9
1 1 1 2 3 4 5 6 7 
Sample Output 0

7

Scored : 50
*/
		
		int len=0;
        for (int i=1;i<arr.size();i++)
        {
            if(arr.get(i)!=arr.get(i-1))
            {
                arr.set(len,arr.get(i));
                len++;
            }
        }
        return len+1;




