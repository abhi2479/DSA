/*
Given an array of integers arr and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Input Format

First line is the length of the array
Second line is the target value
Next line contains element of the array

Constraints

2 <= arr.length <= 104
-109 <= arr[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

Output Format

Return array of indices

Sample Input 0

6
3
1 2 3 4 5 6
Sample Output 0

0 1

Scored : 50
*/		
		
		int left=0,right=arr.size() -1;
        List<Integer> temp = new ArrayList<>();
        
        int[][] arr1 = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            arr1[i][0] = arr.get(i);
            arr1[i][1] = i;
        }
        Arrays.sort(arr1, (a, b) -> Integer.compare(a[0], b[0]));
        
        
        while(left<right)
        {
            if(arr1[left][0]+arr1[right][0]==target)
            {
                temp.add(arr1[left][1]);
                temp.add(arr1[right][1]);
                break;
            }
            else if(arr1[left][0]+arr1[right][0]<target)
                left++;
            else 
                right--;
			
        }
        
        return temp;
	
	

			