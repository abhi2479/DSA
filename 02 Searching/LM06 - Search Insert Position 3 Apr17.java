/* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Input Format

First line is the length of the array
Second line is the target element
Next line is the elements of the array

Constraints

1 <= arr.length <= 104
-104 <= arr[i] <= 104
arr contains distinct values sorted in ascending order.

Output Format

Return the position in the array

Sample Input 0

4
5
1 3 5 6
Sample Output 0

2
 */
 



		int start=0,end=n-1,mid,res=0;
        while(start<=end)
        {
            mid= start + (end-start)/2;
            if(arr.get(mid)==target)
                return mid;
            
            if(arr.get(mid)<target)
                start=mid+1;
            else
                end=mid-1;
            
        }
 
        return start;