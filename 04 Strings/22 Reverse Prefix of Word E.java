/* Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.

 

Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3. 
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
Example 2:

Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
Example 3:

Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
 

Constraints:

1 <= word.length <= 250
word consists of lowercase English letters.
ch is a lowercase English letter. */

class Solution {
    public String reversePrefix(String word, char ch) {
       int index=0;
       StringBuilder str = new StringBuilder();
       for(int i=0;i<word.length();i++)
       {
           if(ch==word.charAt(i))
            {
                index=i;
                break;
            }
       } 

       if(index==0)
        return word;
       else
       {
           int j=index;
           while(j>=0)
           {
               str.append(word.charAt(j));
               j--;
           }

           j=index+1;
           while(j<word.length())
           {
               str.append(word.charAt(j));
               j++;
           }

           return str.toString();
       } 
    }
}