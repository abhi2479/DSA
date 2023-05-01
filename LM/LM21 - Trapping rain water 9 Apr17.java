/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input Format

First line is the length of the array
Next line is elements of the array

Constraints

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

Output Format

Return single integer that is how much water stored

Sample Input 0

12
0 1 0 2 1 0 1 3 2 1 2 1
Sample Output 0

6
Sample Input 1

3
1 10 0
Sample Output 1

0 */

//For better understanding of the question -> https://www.geeksforgeeks.org/trapping-rain-water/


int maxl=0,maxr=0,l=0,r=hei.size()-1;
        int sum=0;
        
        while(l<=r)
        {
            if(hei.get(l)<=hei.get(r))
            {
                if(maxl<=hei.get(l))
                    maxl=hei.get(l);
                else
                    sum+=maxl-hei.get(l);
                
                l++;
            }
            else
            {
                if(maxr<=hei.get(r))
                    maxr=hei.get(r);
                else
                    sum+=maxr-hei.get(r);
                
                r--;
            }
        }
        
        return sum;