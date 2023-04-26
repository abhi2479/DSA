/* You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.

 

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
 

Constraints:

1 <= s.length <= 1000
s consists of digits and the '#' letter.
s will be a valid string such that mapping is always possible. */


```class Solution {
    public String freqAlphabets(String s) {
        
       StringBuilder str =new StringBuilder();
        
        for(int i=s.length()-1;i>=0;i--){
           char c=s.charAt(i);
            if(c=='#'){
                
                i--;
                //storing two digit number
              String temp=s.charAt(i-1) + "" + s.charAt(i);
                int n = Integer.parseInt(temp);
				//converting number intop character
                str.append((char)(96+n));
                
                i--;
            }
            else{
                
            String  temp  =c+"";
			//converting string into number
               int n=Integer.parseInt(temp);
              
			  //converting number intop character
              str.append((char)(96+n));
               
           
            }
        }
        
       str.reverse();
        return str.toString();
    }
}

//============================================================================

class Solution {
    public String freqAlphabets(String s) {
        int i=s.length()-1;
        StringBuilder str= new StringBuilder();
        while(i>=0)
        {
            if(s.charAt(i)=='#')
            {
                i--;
                String temp=s.charAt(i-1) + "" + s.charAt(i);
                int n = Integer.parseInt(temp);
                str.append((char)(n+96));
                i--;
            }
            else
            {
                int n = Integer.parseInt(s.charAt(i)+"");
                str.append((char)(n+96)); 
            }
            i--;

        }

        return str.reverse().toString();
    }
}