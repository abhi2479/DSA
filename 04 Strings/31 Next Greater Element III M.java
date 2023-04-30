/* Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1

Input: n = 5698732
Output : 5723689
 

Constraints:

1 <= n <= 231 - 1 */

//https://leetcode.com/problems/next-greater-element-iii/solutions/2597736/0ms-java-solution-100-with-explanation/?orderBy=most_votes&languageTags=java

class Solution {
    public int nextGreaterElement(int n) {
        char[] num=(n+"").toCharArray();
        int index=0,i;

        for(i=num.length-1;i>0;i--)
        {
            if(num[i-1]<num[i])
            {
                index=i-1;
                break;
            }
        }

        if(i==0)
            return -1;

        int index2=0,min=-1;

        for(i=index+1;i<num.length;i++)
        {
            if(num[i]>num[index])
                {
                    min=Math.min(num[i],min);
                    index2=i;
                }
        }

        char temp=num[index];
        num[index]=num[index2];
        num[index2]=temp;

        Arrays.sort(num, index+1, num.length);
        
        long val = Long.parseLong(new String(num));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;




    }
}