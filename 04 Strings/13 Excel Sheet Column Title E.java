/* Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...

 

Example 1:

Input: columnNumber = 1
Output: "A"

Example 2:

Input: columnNumber = 28
Output: "AB"

Example 3:

Input: columnNumber = 701
Output: "ZY"

 

Constraints:

    1 <= columnNumber <= 231 - 1

 */
 
 class Solution {
    public String convertToTitle(int num) {
        StringBuilder str= new StringBuilder();

        while(num>0)
        {
            num-=1;                                   // n-- to handle n==26
            int n=num%26;
            str.append((char)(n+65));
            num/=26;
        }
        
        return str.reverse().toString();
    }
}