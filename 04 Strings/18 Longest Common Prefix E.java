/* Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.

 */
 
 class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first=strs[0];
        String last=strs[strs.length-1];

        int match=0,i=0,j=0;

        while(i<first.length() && j<last.length())
        {
            if(first.charAt(i)==last.charAt(j))
                match++;
            else
                break;

            i++;
            j++;
        }

        if(match==0)
            return "";
        else
            return first.substring(0,match);
    }
}