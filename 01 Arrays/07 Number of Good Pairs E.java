/* Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100 */

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        
        for(int i = 0; i<nums.length - 1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}

//================================================================

public int numIdenticalPairs(int[] nums) {
    int cnt[] = new int[101], res = 0;
    for (var n: nums)
        ++cnt[n];
    for (int i = 0; i <= 100; ++i)
        res += cnt[i] * (cnt[i] - 1) / 2;
    return res;     
}

// Number of combinations that can be formed out of "N elements", by selecting only "2 elements" at a time = NC2 = N * (N - 1) / 2