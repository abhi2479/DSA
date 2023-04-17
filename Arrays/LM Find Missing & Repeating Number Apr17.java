/* You are given a read-only array of N integers with values also in the range [1,N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Input Format

First line is the length of the array - n
Second line contains n integer that is elements of the array

Constraints

1 <= n <= 105
1 <= arr[i] <= n

Output Format

Print array of integers containing repeating and missing number respectively

Sample Input 0

3
3 1 3
Sample Output 0

3 2
Explanation 0

A = 3 , B = 2 Since 3 is appearing twice and 2 is missing */


//Swapping to original place

		int temp,i=0,n=arr.size(),missing=0,repeating=0;
        List<Integer> ans=new ArrayList<Integer>();
        
        while(i<n)
        {
            int num=arr.get(i)-1;
                if(Objects.equals(arr.get(i),arr.get(num)))
                    i++;
                else
                {
                    temp=arr.get(i);
                    arr.set(i,arr.get(num));
                    arr.set(num,temp);
                }
        }
        
        
        for(i=0;i<n;i++)
        {
            if(arr.get(i)!=i+1)
            {
                missing =i+1;
                repeating=arr.get(i);
                break;
            }
        }
        ans.add(repeating);
        ans.add(missing);
        
        return ans;
		
		
//==================================================================================


//Marking

int i=0,missing=0,repeating=0,n=arr.size();
        List<Integer> ans=new ArrayList<Integer>();
        while(i<n)
        {
            int num=arr.get(i);
            int ab=Math.abs(num);
            if(arr.get(ab-1)>0)
                arr.set(ab-1,arr.get(ab-1)*-1);
            else
                repeating=ab;
            
            i++;
        }
        
        for(i=0;i<n;i++)
        {
            if(arr.get(i)>0)
                missing=i+1;
        }
        
        ans.add(repeating);
        ans.add(missing);
        return ans;

