/* Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [1,3,5]
Output: 1
Example 2:

Input: nums = [2,2,2,0,1]
Output: 0
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.
 

Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why? */

class Solution {
    public int findMin(int[] nums) {
        int pivot=findPivot(nums);
        int n=nums.length;
        if(n==0)
            return -1;

        if(pivot==-1 || pivot==n-1)
            return nums[0];
        else
            return nums[pivot+1];
    }

    public int findPivot(int[] nums)
    {
        int start=0,end=nums.length-1,mid;

        while(start<=end)
        {
            mid=(end-start)/2 + start;
            if(mid+1<=end && nums[mid]>nums[mid+1])
                return mid;
            if(mid-1>=0 && nums[mid]<nums[mid-1])
                return mid-1;

            if(nums[start]==nums[mid] && nums[mid]==nums[end])
            {
                if(start+1<=end && nums[start]>nums[start+1])
                    return start;
                if(end-1>=0 && nums[end]<nums[end-1])
                    return end-1;

                start++;
                end--;
            }
            else if(nums[start]<nums[mid] || nums[start]==nums[mid] && nums[mid]>nums[end])
            {
                start=mid+1;
            }
            else
                end=mid-1;
            
        }
        return -1;
    }
}