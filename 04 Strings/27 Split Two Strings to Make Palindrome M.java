/* You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.

When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.

Return true if it is possible to form a palindrome string, otherwise return false.

Notice that x + y denotes the concatenation of strings x and y.

 

Example 1:

Input: a = "x", b = "y"
Output: true
Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
aprefix = "", asuffix = "x"
bprefix = "", bsuffix = "y"
Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
Example 2:

Input: a = "xbdef", b = "xecab"
Output: false
Example 3:

Input: a = "ulacfd", b = "jizalu"
Output: true
Explaination: Split them at index 3:
aprefix = "ula", asuffix = "cfd"
bprefix = "jiz", bsuffix = "alu"
Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 

Constraints:

1 <= a.length, b.length <= 105
a.length == b.length
a and b consist of lowercase English letters */



//https://leetcode.com/problems/split-two-strings-to-make-palindrome/solutions/1400818/java-simple-solution-with-detailed-explanation/?orderBy=most_votes&languageTags=java
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return split(a, b) || split(b, a);
    }
    
    private boolean split(String a, String b) {
        int left = 0, right = a.length() - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) return true;
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

//============================================================================

//https://leetcode.com/problems/split-two-strings-to-make-palindrome/solutions/889063/java-o-n/?orderBy=most_votes&languageTags=java

		class Solution{
      public boolean checkPalindromeFormation(String a, String b) {
        if( isPalindrome(a)||isPalindrome(b))
            return true;
        return solve(a,b) || solve(b,a);
    }
    
    private boolean solve(String a, String b){
        int i = 0;
        int j = b.length()-1;
        
        while(a.charAt(i) == b.charAt(j)){
            i++;
            j--;
            if(j==-1)
                return true;
        }
        
        String ABB = a.substring(0,i) + b.substring(i);
        String AAB = a.substring(0,a.length()-i) + b.substring(b.length()-i);
        
        return isPalindrome(ABB) || isPalindrome(AAB);
    }
    
    private boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
  }