//https://www.youtube.com/watch?v=Ppy9lvyMnuc&ab_channel=MichaelMuinos
/*

Divide Chocolate Problem
https://curiouschild.github.io/leetcode/2019/06/21/divide-chocolate.html

*/



	
class Solution {
    public int Sweetness(int[] arr, int k) {

        k=k+1;
        int n=arr.length;
        int sum=0,min=Integer.MAX_VALUE,ans=0;

        for(int num:arr)
        {
            min=Math.min(min,num);
            sum+=num;
        }

        int start=min,end=sum/k,mid=0;
        while(start<=end)
        {
            sum=0;
            int chunk=0;
            mid=(start+end)/2;

            for (int j : arr) {
                sum += j;
                if (sum >= mid) {
                    chunk++;
                    sum = 0;
                }
            }

            if(chunk>=k)
            {
                ans=mid;
                start=mid+1;
            }
            else
            {
                end = mid-1;
            }
        }

        return ans;

    }