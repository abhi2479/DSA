/* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> arr = new ArrayList<>();
        int n1=nums1.length;
        int n2=nums2.length;

        if(n1<n2)
        {
            Arrays.sort(nums2);
            for (int num : nums1) {
                if (binarySearch(nums2, num)) {
                    arr.add(num);
                }
            }
        }
        else
        {
            Arrays.sort(nums1);
            for (int num : nums2) {
                if (binarySearch(nums1, num)) {
                    arr.add(num);
                }
            }
        }
        
        int i = 0;
        int[] result = new int[arr.size()];
        for (Integer num : arr) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                {
                    nums[mid]=-1;
                    Arrays.sort(nums);
                    return true;
                }
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}