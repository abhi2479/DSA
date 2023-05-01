			
/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Input Format

First line is the length of the array
Second line is target value
Next line is elements of the array

Constraints

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104

Output Format

Return sum of the closest integer to target value

Sample Input 0

4
1
-1 2 1 -4
Sample Output 0

2
Sample Input 1

3
1
0 0 0
Sample Output 1

0


*/
		
		int i=0,j=arr.size()-1,k=0,sum=0,diff=Integer.MAX_VALUE;
        Collections.sort(arr);
        
        for(i=0;i<arr.size();i++)
        {
           k=i+1; 
		   j=arr.size()-1;
           while (k<j)
            { 
               
               sum = arr.get(i)+arr.get(k)+ arr.get(j);
                if(Math.abs(target-sum)<Math.abs(target-diff))
                {
                    diff=sum;
                }
                if(sum<target)
                 k++;
                else
                 j--;   
            
           }     
        }
            
         return diff;
    
    
