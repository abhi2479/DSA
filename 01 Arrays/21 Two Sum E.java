/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity? */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int k=0;
        int j=nums.length-1;
        int[] arr = new int[2];

        int[][] ar=new int[j+1][2];
        for ( int i = 0; i < j+1; i++) {
            ar[i][0] = nums[i];
            ar[i][1] = i;
        }
        Arrays.sort(ar,(a,b) -> Integer.compare(a[0], b[0]) );
        while(k<j)
        {
            if(ar[k][0]+ar[j][0]==target)
            {
                arr[0]=ar[k][1];
                arr[1]=ar[j][1];
                break;
            }
            else if(ar[k][0]+ar[j][0]>target)
            j--;
            else
            k++;
        }
        return arr;
    }
}