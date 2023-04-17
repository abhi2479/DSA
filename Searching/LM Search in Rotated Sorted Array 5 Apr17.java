/* Given an array of distinct elements, which is formed from some places rotation of a sorted array, find if a given element is present in the array or not.
Note: Try to do it in O(logn) runtime complexity

Input Format

First line is the length of the array
Second line is the target element
Next line is the elements of the array

Constraints

1 <= arr.length <= 5000
-104 <= arr[i] <= 104
All values of arr are unique.
arr is an ascending array that is possibly rotated.
-104 <= target <= 104

Output Format

Return the index of target if it is in array, or -1 if it is not in array.

Sample Input 0

7
0
4 5 6 7 0 1 2
Sample Output 0

4 */

int s=0,e=arr.size()-1,m;
        while(s<=e)
        {
            m=s+(e-s)/2;
            if(arr.get(m)==target)
                return m;
            
            if(arr.get(m)>=arr.get(s))
            {
                if(target<arr.get(m)&& target >=arr.get(s))
                    e=m-1;
                else
                    s=m+1;
            }
            if(arr.get(m)<=arr.get(e))
            {
                if(target>arr.get(m) && target <=arr.get(e))
                    s=m+1;
                else
                    e=m-1;
            }
        }
        return -1;