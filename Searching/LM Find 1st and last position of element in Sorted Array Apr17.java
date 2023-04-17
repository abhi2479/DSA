/* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
Note: You must write an algorithm with O(log n) runtime complexity.

Input Format

First line is the length of the array
Second line is the target value
Next line is the elements of the array

Constraints

0 <= nums.length <= 105
-109 <= nums[i] <= 109
array is a non-decreasing array.
-109 <= target <= 109

Output Format

Return the indices of start and end position in the array

Sample Input 0

6
8
5 7 7 8 8 10
Sample Output 0

3 4 */





int n=arr.size();
        int mid=0,start=0,end=n-1,si=-1,ei=-1;
        List<Integer> ans=new ArrayList<Integer>();
        while(start<=end)
        {
            mid=start + (end - start)/2;
            if(arr.get(mid)==target)
            {
                si=mid;
                end=mid-1;
            }
            else if(arr.get(mid)>target)
                end=mid-1;
            else
                start=mid+1;
        }
        
        start=0;end=n-1;mid=0;
        
        while(start<=end)
        {
            mid=start + (end - start)/2;
            if(arr.get(mid)==target)
            {
                ei=mid;
                start=mid+1;
            }
            else if(arr.get(mid)>target)
                end=mid-1;
            else
                start=mid+1;
        }
        
        ans.add(si);
        ans.add(ei);
        
        return ans;
        