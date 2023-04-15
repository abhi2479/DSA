/* Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Input Format

Integer N.
Integer Array of size N.

Constraints

1 <= N <= 10^6
0 <= A[i] <= 2
Output Format

Integer Array of size N.

Sample Input 0

5
0 1 2 1 2
Sample Output 0

0 1 1 2 2
Explanation 0

0s 1s and 2s are segregated into ascending order. */



int x=1,temp,pointer=0;
        int i=0,j=n-1;
        while(pointer<=j)
        {
            if(arr.get(pointer)<x)
            {
                temp=arr.get(pointer);
                arr.set(pointer,arr.get(i));
                arr.set(i,temp);
                i++;
                pointer++;
            }
                
            else if(arr.get(pointer)>x)
            {
                temp=arr.get(pointer);
                arr.set(pointer,arr.get(j));
                arr.set(j,temp);
                j--;
            }
            else
                pointer++;
        }
        
        return arr;