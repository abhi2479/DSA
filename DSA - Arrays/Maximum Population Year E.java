/* You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

 

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

Example 2:

Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation: 
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960.

 

Constraints:

    1 <= logs.length <= 100
    1950 <= birthi < deathi <= 2050

 */
 
 class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] pop = new int[101];
        for (int[] log : logs) {
            pop[log[0] - 1950]++;
            pop[log[1] - 1950]--;
        }
        int maxPop = 0, maxYear = 0, currPop = 0;
        for (int i = 0; i < 101; i++) {
            currPop += pop[i];
            if (currPop > maxPop) {
                maxPop = currPop;
                maxYear = i + 1950;
            }
        }
        return maxYear;
    }
}

//*************************************************************************************************

// To return max population

int n=logs.length;
        int[] birth = new int[n];
        int[] death = new int[n];
        int i,j;
        for(i=0;i<n;i++)
        {
            birth[i]=logs[i][0];
            death[i]=logs[i][1];
        }

        Arrays.sort(birth);
        Arrays.sort(death);
        int count=0,max=0;
        i=0;j=0;

        while(i<n)
        {
            if(birth[i]<=death[j])
            {
                count++;
                i++;
            }
            else if(death[j]<birth[i])
            {
                count--;
                j++;
            }
            max=Math.max(max,count);
        }
        return max;