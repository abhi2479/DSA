/* Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.

 

Example 1:

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.
Example 2:

Input: s = "110"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i]​​​​ is either '0' or '1'.
s[0] is '1'. */

//Check for 01 together , false if present

class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()<1)
            return false;

        if(s.length()==1 && s.charAt(0)=='1')
            return true;

        int i=0;
        while(i<s.length()-1)
        {
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1')
                return false;
            else
                i++;
        }

        return true;

    }
}