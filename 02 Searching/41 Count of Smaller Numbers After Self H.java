/* Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:

Input: nums = [-1]
Output: [0]

Example 3:

Input: nums = [-1,-1]
Output: [0,0]

 

Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

 */
 
 //https://leetcode.com/problems/count-of-smaller-numbers-after-self/solutions/2323654/c-c-solution-using-binary-search-easy-o-nlogn/?orderBy=most_votes&topicTags=binary-search
 
 class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        List<Integer> sort=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();


         for(int i=n-1;i>=0;i--)
         {
            int pos=bs(sort,nums[i]);
            sort.add(pos+1,nums[i]);
            ans.add(pos+1);
         }
        Collections.reverse(ans);
        return ans;
    }

    public int bs(List<Integer> arr,int num)
    {
        int start=0,end=arr.size()-1,mid;
        while(start<=end)
        {
            mid=(end-start)/2 + start;
            if(arr.get(mid)<num)
                start=mid+1;
            else
                end=mid-1;
        }
        return end;
    }

    
}