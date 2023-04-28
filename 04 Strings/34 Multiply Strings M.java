/* Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself. */

class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length(),n=num2.length();

        int[] res=new int[m+n];

        if("0".equals(num1) || "0".equals(num2))
            return "0";

        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

       for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int prod=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                prod+=res[i+j+1];
                res[i+j+1]=(prod%10);
                res[i+j]+=prod/10;
            }
        }

        int i=0;
        while(res[i]==0)
        {
            i++;
        }

        StringBuilder str=new StringBuilder();

        for(int j=i;j<m+n;j++)
            str.append(res[j]);

        return str.toString();
    }
}