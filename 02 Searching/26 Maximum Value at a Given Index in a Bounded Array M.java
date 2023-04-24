/* You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

    nums.length == n
    nums[i] is a positive integer where 0 <= i < n.
    abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
    The sum of all the elements of nums does not exceed maxSum.
    nums[index] is maximized.

Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.

 

Example 1:

Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].

Example 2:

Input: n = 6, index = 1,  maxSum = 10
Output: 3

 

Constraints:

    1 <= n <= maxSum <= 109
    0 <= index < n

 */
 
 
 //https://www.youtube.com/watch?v=MjpAAE3-hYg&ab_channel=CherryCoding%5BIIT-G%5D
 
 class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long start=1,end=maxSum,mid;
        long lSum=0,rSum=0,midLess1;

        long sum=0,res=0,rEmptyPlaces=n-index-1,lEmptyPlaces=index;

        while(start<=end)
        {
            mid=(end-start)/2 + start;
            midLess1=mid-1;

            if(rEmptyPlaces<=midLess1)
                rSum=midLess1*(midLess1+1)/2 - (midLess1-rEmptyPlaces)*(midLess1-rEmptyPlaces+1)/2;
            else
                rSum=midLess1*(midLess1+1)/2 + 1*(rEmptyPlaces-midLess1);

            if(lEmptyPlaces<=midLess1)
                lSum=midLess1*(midLess1+1)/2 - (midLess1-lEmptyPlaces)*(midLess1-lEmptyPlaces+1)/2;
            else
                lSum=midLess1*(midLess1+1)/2 + 1*(lEmptyPlaces-midLess1);

            sum=lSum+rSum+mid;

            if(sum<=maxSum)
            {
                res=mid;
                start=mid+1;
            }
            else
                end=mid-1;
            
        }

        return (int)res;
    }
}

