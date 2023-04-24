/* Given an integer x, find the square root of x. If x is not a perfect square, then return floor(√x).

Input Format

Number N

Constraints

0 <= N <= 108

Output Format

Integer N

Sample Input 0

10
Sample Output 0

3
Sample Input 1

16
Sample Output 1

4 */


		if(n==0)
            return 0;
        int start=1,end=n,mid,ans,res=1,temp;
        while(start<=end)
        {
            mid=start + (end-start)/2;
            
            if(mid<=n/mid && ((mid+1)>n/(mid+1)))
            {
                res=mid;
                break;
            }
            
            if(mid<n/mid)
                start=mid+1;
            else
                end=mid;
            
            
        }
        
        return res;
		



