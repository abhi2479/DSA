/* You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Input Format

First line is the length of the array
Next line is the elements of the array

Constraints

1 <= arr.length <= 105
0 <= arr[i] <= 105

Output Format

Return the single element

Sample Input 0

7
3 3 7 7 10 11 11
Sample Output 0

10 */

int start=0,end=n-1,mid=0;
        while(start<end)
        {
            mid=start + (end-start)/2;
            if ((mid % 2 == 1 && Objects.equals(arr.get(mid), arr.get(mid - 1))) || (mid % 2 == 0 && Objects.equals(arr.get(mid), arr.get(mid + 1))))
                    start = mid + 1;
            else
                end=mid;
        }
        return arr.get(start);
