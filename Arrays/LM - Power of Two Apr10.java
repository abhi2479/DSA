/* Given an integer n, return 1 if it is a power of two. Otherwise, return 0.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Input Format

Integer n

Constraints

-231 <= n <= 231 - 1
Output Format

0/1

Sample Input 0

1
Sample Output 0

1
Explanation 0

20 = 1

Sample Input 1

16
Sample Output 1

1
Explanation 1

24 = 16

Submissions: 1
Max Score: 50
Difficulty: Medium
Rate This Challenge:

    
More
 */
 
public static int powerOfTwo(int n) {
    // Write your code here
        if(n==0)
            return 0;
        
        if(Math.ceil(Math.log(n)/Math.log(2))==Math.floor(Math.log(n)/Math.log(2)))
            return 1;
        else 
            return 0;
    }