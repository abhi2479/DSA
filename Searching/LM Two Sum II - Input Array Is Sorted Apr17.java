/* Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Input Format

Integer target.
Integer n.
Integer array of lenght n.

Constraints

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
Output Format

Integer array of lenght 2.

Sample Input 0

9
4
2 7 11 15
Sample Output 0

1 2
Explanation 0

The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Sample Input 1

6
3
2 3 4
Sample Output 1

1 3
Explanation 1

The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3]. */


//Using Binary Search

		int left=0,right=n-1,start,end,mid,sum;
        List<Integer> ans=new ArrayList<Integer>();
        while(left<right)
        {
            mid=left +(right-left)/2;
            sum=arr.get(left)+arr.get(right);
            if(sum==target)
            {
                ans.add(left+1);
                ans.add(right+1);
                break;
            }
            else if(sum<target)
            {
                if(arr.get(mid)+arr.get(right)<target)
                    left=mid;
                else
                    left++;
            }
            else
            {
                if(arr.get(mid)+arr.get(left)<target)
                    right--;
                else
                    right=mid;
            }
            
            
        }
        return ans;