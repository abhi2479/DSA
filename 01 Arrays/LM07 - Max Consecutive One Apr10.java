/* Given a binary array nums, return the maximum number of consecutive 1's in the array.

Input Format

First line is the length of the array
Next line is elements of the array

Constraints

1 <= arr.length <= 105
arr[i] is either 0 or 1.

Output Format

Return the maximum number of consecutive 1's in the array.

Sample Input 0

6
1 1 0 1 1 1
Sample Output 0

3 */

int max=0,i=0,count=0;
        while(i<arr.size())
        {
            if(arr.get(i)==1)
                count++;
            else
                count=0;
            
            i++;
            max=Math.max(max,count);
        }
        return max;