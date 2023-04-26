/* Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999]. */

class Solution {
    public int romanToInt(String s) {
        int sum=0,value=0,value2=0;
        int i=0;char c;
        while(i<s.length())
        {
            char ch=s.charAt(i);
            value=0;value2=0;
            if(i+1<s.length())
                {
                    c=s.charAt(i+1);
                    switch(c)
                    {
                        case 'I' : value2=1;
                                    break;
                        case 'V' : value2=5;
                                    break;
                        case 'X' : value2=10;
                                    break;
                        case 'L' : value2=50;
                                    break;
                        case 'C' : value2=100;
                                    break;
                        case 'D' : value2=500;
                                    break;
                        case 'M' : value2=1000;
                                    break;
                    }
                }
            switch(ch)
            {
                case 'I' : value=1;
                         break;
                case 'V' : value=5;
                         break;
                case 'X' : value=10;
                         break;
                case 'L' : value=50;
                         break;
                case 'C' : value=100;
                         break;
                case 'D' : value=500;
                         break;
                case 'M' : value=1000;
                         break;
            }
            
            if(value>=value2)
                {
                    sum+=value;
                    i++;
                }
            else{
                sum+=(value2-value);
                i+=2;
            } 
                
        }

        return sum;
    }
}

//================================================================

public int romanToInt(String s) {
    
    int answer = 0, number = 0, prev = 0;

    for (int j = s.length() - 1; j >= 0; j--) {
        switch (s.charAt(j)) {
            case 'M' -> number = 1000;
            case 'D' -> number = 500;
            case 'C' -> number = 100;
            case 'L' -> number = 50;
            case 'X' -> number = 10;
            case 'V' -> number = 5;
            case 'I' -> number = 1;
        }
        if (number < prev) {
            answer -= number;
        }
        else {
            answer += number;
        }
        prev = number;
    }
    return answer;
}