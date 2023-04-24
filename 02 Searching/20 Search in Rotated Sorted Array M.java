/* There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

 

Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104

 */
 
 class Solution {
    public int search(int[] nums, int target) {
        int index=pivot(nums);
        int ans=-1;
        if(nums[index]==target)
            return index;
        else if(target>=nums[0])
            ans=search(nums,target,0,index);
        else
            ans=search(nums,target,index+1,nums.length-1);

        return ans;
    }

    public int pivot(int[] nums)
    {
        int s=0,e=nums.length-1,m=0;
        if(nums.length<=1)
            return 0;

        while(s<=e)
        {
            m=s+(e-s)/2;

            if(m+1<=e && nums[m]>nums[m+1])
                return m;
            
            if(nums[m]>=nums[s])
                s=m+1;
            else
                e=m-1;
        }

        return m;
    }

    public int search(int[] nums, int target,int s,int e) {
        int m;

        while(s<=e)
        {
            m=s+(e-s)/2;
            if(nums[m]==target)
                return m;

            if(nums[m]<target)
                s=m+1;
            else
                e=m-1;
        }

        return -1;
    }
}