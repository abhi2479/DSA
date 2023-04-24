/* You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

 

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.

Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.

 

Constraints:

    1 <= intervals.length <= 2 * 104
    intervals[i].length == 2
    -106 <= starti <= endi <= 106
    The start point of each interval is unique. */
	
	
//https://www.youtube.com/watch?v=BWZmkS0ed-o&ab_channel=NareshGupta
	
	
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int start[][]=new int[n][2];
        for(int i=0;i<n;i++){
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }
        Arrays.sort(start, (a,b) -> (a[0] - b[0]));
        int ans[] = new int[n];
        for(int i=0;i<n;i++) {
            int target = intervals[i][1];
            int l = 0, r = n-1;
            while(l<=r) {
                int mid = (l+r)/2;
                if(start[mid][0] >= target) r = mid - 1;
                else if(start[mid][0] < target) l = mid + 1;   
            }
            if(l<n) ans[i] = start[l][1];
            else ans[i] = -1;
        }
        return ans;
    }
}

