/* Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity? */

//https://leetcode.com/problems/find-the-duplicate-number/solutions/1892921/9-approaches-count-hash-in-place-marked-sort-binary-search-bit-mask-fast-slow-pointers/?orderBy=most_votes&topicTags=binary-search



class Solution {
    public int findDuplicate(int[] nums) {
        int start=1,end=nums.length-1,count=0;
        while(start<end)
        {
            int mid=(end-start)/2 + start;
            count=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]<=mid)
                    count++;
            }

            if(count<=mid)
                start=mid+1;
            else
                end=mid;
        }
        return start;
    }
}