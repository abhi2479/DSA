/* Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

 

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0

 

Constraints:

    2 <= timePoints.length <= 2 * 104
    timePoints[i] is in the format "HH:MM".
 */
 
 class Solution {
    public int findMinDifference(List<String> timeP) {
        int n=timeP.size();

        int[] arr=new int[n];
        int i=0;

        for(String time : timeP)
        {
            int hours=Integer.parseInt(time.substring(0,2));
            int minutes=Integer.parseInt(time.substring(3));

            arr[i++]=(hours*60 + minutes);
        }

        Arrays.sort(arr);

        int min=Integer.MAX_VALUE;
        for(i=1;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1]<min)
                min=arr[i]-arr[i-1];
        }

        int m=Math.abs(1440-arr[arr.length-1]+arr[0]);
        if(m<min)
            min=m;

        return min;
    }
}