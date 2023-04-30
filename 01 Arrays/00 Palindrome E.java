/* Given an integer x, return true if x is a
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 

Constraints:

    -231 <= x <= 231 - 1 

 
Follow up: Could you solve it without converting the integer to a string? */

class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}

//========================================================================

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);  // convert integer to string.

        int i = 0;                     // i will initially point to first index.
        int j = s.length() - 1;        // j will initially point to last index. 
        
        // i and j are opposite indices of the string. 
        // 1. If 'i' is first then 'j' is last.
        // 2. Similarly, if 'i' is second then 'j' is second last index of s.
        // This is because they are updated simultaneously.

        while(i <= j)                   // loop will break when i and j cross each other
        {
            if(s.charAt(i) != s.charAt(j))  // characters at indices i and j will be compared.
                // If the characters are unequal then false will be returned.
                return false;
            i++;                                // i is incremented.
            j--;                                // j is decremented.
        }
        return true;
    }
}