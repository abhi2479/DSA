/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Input Format

First line is length of the array Next line is the elements of the array

Constraints

1 <= arr.length <= 104
0 <= arr[i] <= 231 - 1

Output Format

Return the array as per requirement

Sample Input 0

6
1 2 0 0 3 4
Sample Output 0

1 2 3 4 0 0

Scored : 50
*/

	  int pos=0;
      for (int i=0;i<n;i++)
      {
          if(arr.get(i)!=0)
          {
              arr.set(pos++,arr.get(i));
          }
      }
        
        while(pos<n)
        {
            arr.set(pos++,0);
        }
        
        return arr;

    