/* Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Input Format

Integer c.

Constraints

0 <= c <= 231 - 1
Output Format

Integer 0/1

Sample Input 0

5
Sample Output 0

1
Explanation 0

12 + 22 = 5
 */
 
 
int sq=(int)Math.sqrt(c);
        int i=1,j=sq,ti,tj;
        while(i<j)
        {
            ti=i*i;
            tj=j*j;
            if(ti+tj==c)
                return 1;
            else if(ti+tj<c)
                i++;
            else
                j--;
        }
        
        return 0;