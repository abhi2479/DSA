/* In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

 

Example 1:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: true
Explanation: We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX

Example 2:

Input: start = "X", end = "L"
Output: false

 

Constraints:

    1 <= start.length <= 104
    start.length == end.length
    Both start and end will only consist of characters in 'L', 'R', and 'X'.

 */
 
 
 //https://leetcode.com/problems/swap-adjacent-in-lr-string/solutions/1571655/java-easy-to-understand-with-pictures/?orderBy=most_votes&languageTags=java
 
 class Solution {
    public boolean canTransform(String start, String end) {
        if(!start.replace("X","").equals(end.replace("X","")))
            return false;
        
        int n=start.length();

        List<Integer> ls = new ArrayList<>();
        List<Integer> rs = new ArrayList<>();
        List<Integer> le = new ArrayList<>();
        List<Integer> re = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(start.charAt(i)=='L')
                ls.add(i);
            if(start.charAt(i)=='R')
                rs.add(i);
        }

        for(int i=0;i<n;i++)
        {
            if(end.charAt(i)=='L')
                le.add(i);
            if(end.charAt(i)=='R')
                re.add(i);
        }

        int i=0,j=0;

        while(i<ls.size() && j<le.size())
        {
            if(le.get(j)>ls.get(i))
                return false;

            i++;
            j++;
        }

        i=0;j=0;

        while(i<rs.size() && j<re.size())
        {
            if(re.get(j)<rs.get(i))
                return false;

            i++;
            j++;
        }

        return true;

    }
}

