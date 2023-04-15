/* Perform the Merge sort sorting operation on the given array.

Input Format

First line is the length of the array
Next line is the elements of the array

Constraints

1 <= arr.length <= 105
0 <= arr[i] <= 105

Output Format

Return sorted array

Sample Input 0

5
3 5 24 2 1
Sample Output 0

1 2 3 5 24 */

public static List<Integer> sort(int n, List<Integer> array) {
    // Write your code here
        int l=0,h=n-1;
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=array.get(i);
        mergeSort(l,h,arr);
        
        for(int i=0;i<n;i++)
            array.set(i,arr[i]);
        
        return array;
    }
    
    public static void mergeSort(int l,int h,int[] arr)
    {
        int m;
        if(l<h)
        {
            m=(l+h)/2;
            mergeSort(l,m,arr);
            mergeSort(m+1,h,arr);
            merge(l,m,h,arr);
        }
    }
    
    public static void merge(int l,int m,int h,int[] arr)
    {
        int i=0,k=l,j=0;
        int n1=m+1-l;
        int n2=h-m;
        int[] left=new int[n1];
        int[] right=new int[n2];
        
        for (int x = 0; x < n1; x++)
            left[x] = arr[l + x];
        for (int y = 0; y < n2; y++)
            right[y] = arr[m + 1 + y];
        
        while(i<n1 && j<n2)
        {
            if(left[i]<=right[j])
            {
                arr[k]=left[i];
                i++;
            }
            else
            {
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        
        if(i<n1)
        {
            for(int x=i;x<n1;x++)
            {
                arr[k]=left[x];
                k++;
            }
        }
        else
        {
            for(int x=j;x<n2;x++)
            {
                arr[k]=right[x];
                k++;
            }
        }
    }