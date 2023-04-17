/* You are given a sorted array of integers and a target value. Your task is to implement the binary search algorithm to find the index of the target value in the array, or return -1 if the target value is not in the array.

Input Format

Line 1: Targer Line 2: N length of array Next N line: array of N elements

Constraints

Length of array 1 ≤ n ≤ 10^6
−10^9 ≤ target ≤ 10^9
Output Format

An integer representing the index of the target value in the array, or -1 if the target value is not in the array.

Sample Input 0

7
10
1 2 3 4 5 6 7 8 9 10
Sample Output 0

6
Explanation 0

In the first example, the target value 7 is present in the array at index 6, so the function returns 6.

Sample Input 1

4
5
1 3 5 7 9
Sample Output 1

-1
Explanation 1

In the second example, the target value 4 is not present in the array, so the function returns -1.
 */



		int s=0,e=arr.size()-1,m;
        while(s<=e){
            
            m=s+(e-s)/2;
            if(arr.get(m)==target)
                return m;
            if(arr.get(m)>target)
                e=m-1;
            else
                s=m+1;
        }
        return -1;