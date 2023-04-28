/* Given a string s. Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
Each word would be put on only one column and that in one column there will be only one word.

 

Example 1:

Input: s = "HOW ARE YOU"
Output: ["HAY","ORO","WEU"]
Explanation: Each word is printed vertically. 
 "HAY"
 "ORO"
 "WEU"

Example 2:

Input: s = "TO BE OR NOT TO BE"
Output: ["TBONTB","OEROOE","   T"]
Explanation: Trailing spaces is not allowed. 
"TBONTB"
"OEROOE"
"   T"

Example 3:

Input: s = "CONTEST IS COMING"
Output: ["CIC","OSO","N M","T I","E N","S G","T"]

 

Constraints:

    1 <= s.length <= 200
    s contains only upper case English letters.
    It's guaranteed that there is only one space between 2 words.
 */
 
 class Solution {
    public List<String> printVertically(String s) {
        String[] str=s.split(" ");
        int max=0;

        for(int i=0;i<str.length;i++)
        {
            if(str[i].length()>max)
                max=str[i].length();
        }

        List<String> sl=new ArrayList<>();
        int index=0;

        for(int i=0;i<max;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(String sf:str)
            {
                if(index<sf.length())
                    sb.append(sf.charAt(index));
                else
                    sb.append(" ");
            }

            sl.add(sb.toString().stripTrailing());
            index++;
        }

        return sl;
    }
}