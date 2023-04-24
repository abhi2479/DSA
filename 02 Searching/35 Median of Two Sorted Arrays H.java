/* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 */

//https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2113018/easiest-o-log-min-m-n-iterative-solution-java-code-binary-search/?orderBy=most_votes&languageTags=java&topicTags=binary-search


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1=nums1.length,n2=nums2.length;
        if (n1> n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int beg = 0;
        int end = n1;
        
        while (beg <= end) {
            
            int i = (beg + end) / 2;
            int j = (n1+n2 + 1) / 2 - i;
            
            int n1Left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int n1Right = i == n1 ? Integer.MAX_VALUE : nums1[i];
            int n2Left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int n2Right = j == n2 ? Integer.MAX_VALUE : nums2[j];
            
            if (n1Left <= n2Right && n2Left <= n1Right) {
                if ((n1+ n2) % 2 == 0) {
                    return (Math.max(n1Left, n2Left) + Math.min(n1Right, n2Right)) / 2.0;
                }
                else {
                    return Math.max(n1Left, n2Left);
                }
            }
            else if (n1Left > n2Right) {
                end = i - 1;
            }
            else {
                beg = i + 1;
            }
        }
        return 1;
    }
}