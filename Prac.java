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