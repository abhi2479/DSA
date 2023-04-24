/* You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 */
 
 
 
class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n=arr.length;
        int start=0,end=n-1,mid,res=0;
        while(start<=end)
        {
            mid=start + (end-start)/2;
            if(mid-1>=0 && mid+1<=n-1 && arr[mid]!=arr[mid-1] 
            && arr[mid]!=arr[mid+1])
                return arr[mid];
            
            if(mid%2==1)
            {
                if(mid-1>=0 && arr[mid]== arr[mid-1] )
                    start=mid+1;
                else
                    end=mid-1;
            }
            else
            {
                 if(mid+1<=n-1 && arr[mid] == arr[mid+1] )
                    start=mid+1;
                else
                    end=mid-1;
            }
            
            res=arr[mid];
            
        }
        
        return res;
    }
}

//==========================================================================================

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
}

//============================================================================================


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }   
}