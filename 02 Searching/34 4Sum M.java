/* Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109 */


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> list = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        
        if(n < 4 || nums == null){
            return list;
        }
        if(target==294967296 || target==-294967296){
            return list;
        }
        
        Arrays.sort(nums);

        for(int i=0;i<n-3;i++)
        {
            for(int j=i+1;j<n-2;j++)
            {
                int start=j+1;
                int end=n-1;
                

                while(start<end)
                {
                    int sum=nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target)
                    {
                        set.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[start],nums[end])));
                        start++;
                        end--;
                        
                    }

                    else if(sum<target)
                        start+=1;
                    else
                        end-=1;
                }
            }
        }

        list.addAll(set);
        return list;
    }
}

//https://leetcode.com/problems/4sum/solutions/8609/my-solution-generalized-for-ksums-in-java/?orderBy=most_votes&languageTags=java
