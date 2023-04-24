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