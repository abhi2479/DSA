/* Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

Input Format

First line is the length of the array
Second line is arrival time array
Third line is departure time array

Constraints

1 ≤ n ≤ 50000
0 ≤ A[i] ≤ D[i] ≤ 2359

Output Format

Return the number of minimum station platforms

Sample Input 0

6 
0900 0940 0950 1100 1500 1800
0910 1200 1120 1130 1900 2000
Sample Output 0

3
Sample Input 1

2
0000 0010
0000 0010
Sample Output 1

1 */



        Collections.sort(arr);
        Collections.sort(dep);
        
        int count =0,j=0,max=0,i=0;
            
        while(i<n)
        {
            if(arr.get(i)<=dep.get(j))
            {
                count++;
                i++;
            }
            else if(dep.get(j)<arr.get(i))
            {
                count--;
                j++;
            }
                
            max=Math.max(max,count);   
        }
        return max;