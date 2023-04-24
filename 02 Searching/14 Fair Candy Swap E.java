/* Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.

Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.

 

Example 1:

Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]

Example 2:

Input: aliceSizes = [1,2], bobSizes = [2,3]
Output: [1,2]

Example 3:

Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]

 

Constraints:

    1 <= aliceSizes.length, bobSizes.length <= 104
    1 <= aliceSizes[i], bobSizes[j] <= 105
    Alice and Bob have a different total number of candies.
    There will be at least one valid answer for the given input.
 */
 
 
 
/*  Let Sum of choclates by Alice Be Sa and Sum of choclates by Alice Be Sb

Let the choclates from Alice to Bob be A and from Bob to Alice be B

Sa -A + B = Sb -B+A
2(A-B) = (Sa-Sb)
A-B = (Sa-Sb)/2
A = B+(Sa-Sb)/2

So the goal is to search the elements of Alice such that Bob + (Diff of Sum) exists in the Alice
For optimisation Alice is sorted and Binary search is applied on Alice
 */
 
 
class Solution {
    
    private int binarySearch(int[] arr,int target){ 
        int s=0,e = arr.length-1;
        
        while(s<=e){
            int mid = s+ (e-s)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) s=mid+1;
            else e=mid-1;
            
        }
        return -1;
    }
    
    public int[] fairCandySwap(int[] a, int[] b) { //a = Alice , b=Bob
        int suma=0,sumb=0;
        for(int i=0;i<a.length;i++)
            suma+=a[i];
        for(int i=0;i<b.length;i++)
            sumb+=b[i];
        
        int diff = (suma-sumb)/2;
        
        Arrays.sort(a);
        for(int num:b){
            if (binarySearch(a,num+diff) !=-1) return new int[]{num+diff,num};
        }
        
        return null;
        
    }
}