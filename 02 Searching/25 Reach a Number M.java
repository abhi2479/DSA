/* You are standing at position 0 on an infinite number line. There is a destination at position target.

You can make some number of moves numMoves so that:

On each move, you can either go left or right.
During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.

 

Example 1:

Input: target = 2
Output: 3
Explanation:
On the 1st move, we step from 0 to 1 (1 step).
On the 2nd move, we step from 1 to -1 (2 steps).
On the 3rd move, we step from -1 to 2 (3 steps).
Example 2:

Input: target = 3
Output: 2
Explanation:
On the 1st move, we step from 0 to 1 (1 step).
On the 2nd move, we step from 1 to 3 (2 steps).
 

Constraints:

-109 <= target <= 109
target != 0 */

//https://leetcode.com/problems/reach-a-number/solutions/2665298/java-solution-with-detailed-explanation-binary-search-0ms-faster-than-100/?orderBy=most_votes&topicTags=binary-search

//https://www.youtube.com/watch?v=frjYWZRs624&ab_channel=TheLameCoder



class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);

        int pos,steps=0,sum=0,diff;

        while(sum>=0)
        {
            if(sum==target)
            {
                return steps;
            }

            if(sum<target)
            {
                steps++;
                sum+=steps;
            }

            if(sum>target)
            {
                pos=sum;
                diff=pos-target;
                if(diff%2==0)
                    return steps;
                else
                {
                    if(steps%2==1)
                        return steps+=2;
                    else
                        return steps+=1;
                }
                //sum=-1;
            }
        }

        return 0;
    }
}

//=========================================================================

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}

//=============================================================================

class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);

        int start=1,end=target,mid,steps=0,pos=0;
        long sum=0;

        while(start<=end)
        {
            mid=start+(end-start)/2;

            sum=(long)mid*(mid+1)/2;
            if(sum>=target)
                {
                    pos=(int)sum;
                    steps=mid;
                    end=mid-1;
                }
            else
                start=mid+1;
        }

        while((pos-target)%2!=0)
        {
            steps++;
            pos+=steps;
        }

        return steps;
    }
}