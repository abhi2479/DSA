start=0;
end=n-1;


//peak elememt

while(s<=e)
{
	
	m=(s+e)/2
	if(a[m]<a[m-1] && m-1 >= 0)
		e=mid-1;
	else if(a[m]<a[m+1] && m+1 <= n-1)
		s=mid+1;
	else
		peak=mid;
}

while(s<=e)
{
	m=(s+e)/2
	if(a[m]==target)
		return m;
	else if(a[m-1]== target && m-1>0 )
}


//target's 1st occurence
while(s<=e)
{
	m=(s+e)/2
	if(a[m]==target)
	{
		result=m;
		e=m-1;
	}
	else if(a[m]>target)
		e=m-1;
	else
		s=m+1;
}

//Binary

class Solution {
    public int search(int[] nums, int target) {
        int s=0,e=nums.length-1,m;

        while(s<=e)
        {
            m=s+(e-s)/2;
            if(nums[m]==target)
                return m;

            if(nums[m]<target)
                s=m+1;
            else
                e=m-1;
        }

        return -1;
    }
}

//max product subarray
// #DP

class Solution {
    public int maxProduct(int[] nums) {
        int cmin=1,cmax=1,res=Integer.MIN_VALUE,temp=1;

        for(int i=0;i<nums.length;i++)
        {
            if(res<nums[i])
                res=nums[i];
        }

        for(int n:nums)
        {
            temp=cmax*n;
            cmax=Math.max(Math.max(n*cmax,n*cmin),n);
            cmin=Math.min(Math.min(temp,n*cmin),n);

            res=Math.max(res,cmax);
        }

        return res;
    }
}

//sum of numbers smaller than self
public long[] smallerSum(int n,int arr[])
    {
        int[] ar=arr.clone();
        long sum=0;
        long[] arSum=new long[n];
        long[] ans= new long[n];

        Arrays.sort(ar);
        for(int i=0;i<n;i++)
        {
            arSum[i]=sum;
            sum+=ar[i];
        }

        for(int i=0;i<n;i++)
        {
            int index=bs(ar,arr[i]);
            ans[i]=arSum[index];
        }

        return ans;

    }

    public int bs(int[] arr,int target)
    {
        int s=0,e=arr.length-1,mid;
        while(s<=e)
        {
            mid=(e-s)/2+s;
            if(target<=arr[mid])
                e=mid-1;
            else
                s=mid+1;
        }

        return s;
    }
	
	
//spiral matrix

rowS=0,rowE=mat.length-1,colS=0,colE=mat[0]-1.length

List<Integer> res=new ArrayList<>(); 
while(rowS<=rowE && colS<=colE)
switch(dir){
case0:
for(i=colS;i<=colE;i++)
	res.add(mat[rowS][i])

rowS++;
break;

case1:
for(i=rowS;i<=rowE;i++)
	res.add(mat[i][colE])

ColE--;
break;

case2:
for(i=colE;i>=colS;i--)
	res.add(mat[rowE][i])

rowE--;
break;
case3:
for(i=rowE;i>=rowS;i--)
	res.add(mat[i][colS])

colS++;
break;

}
dir=(dir+1)%4;
}







