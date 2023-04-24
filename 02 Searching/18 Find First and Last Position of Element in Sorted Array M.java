/* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */
 
 


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startIndex=search(nums,target,true);
        int lastIndex=search(nums,target,false);

        int[] ans = new int[2];
        ans[0]=startIndex;
        ans[1]=lastIndex;
        
            return ans;
    }

    public int search(int[] nums, int target , boolean isFirst) {
        int s=0,e=nums.length-1,m;
        int found=-1;
        if(isFirst)
        {
            while(s<=e)
            {
                m=s+(e-s)/2;
                if(nums[m]==target)
                    {
                        found=m;;
                        e=m-1;
                    }
                else if(nums[m]>target)
                    e=m-1;
                else
                    s=m+1;
            }
            return found;
        }
        else
        {
            while(s<=e)
            {
                m=s+(e-s)/2;
                if(nums[m]==target)
                    {
                        found=m;
                        s=m+1;
                    }
                else if(nums[m]>target)
                    e=m-1;
                else
                    s=m+1;
            }

            return found;
        }
    }
}