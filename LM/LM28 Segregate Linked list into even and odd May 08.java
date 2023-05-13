/* Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.
NOTE: Don't create a new linked list, instead rearrange the provided one.

Input Format

Integer N. N element for linked list.

Constraints

1 <= N <= 104
Output Format

Linked list node, of integer data-type.

Sample Input 0

7
17
15
8
9
2
4
6 
Sample Output 0

8 2 4 6 7 17 15 9 */



 public static SinglyLinkedListNode SegregateLLEvenOdd(SinglyLinkedListNode start) {
    // Write your code here
        
        SinglyLinkedListNode even=null;
        SinglyLinkedListNode etail=null;
        SinglyLinkedListNode odd=null;
        SinglyLinkedListNode otail=null;
        
        
        while(start!=null)
        {
            if(start.data%2==0)
            {
                if(even==null)
                    even=etail=start;
                else
                {
                    etail.next=start;
                    etail=etail.next;
                }
            }
            else if(start.data%2==1)
            {
                if(odd==null)
                    odd=otail=start;
                else
                {
                    otail.next=start;
                    otail=otail.next;
                }
            }
            
            start=start.next;
        }
        
        if(even==null)
            return odd;
        if(odd==null)
            return even;
        
        etail.next=odd;
        otail.next=null;
        return even;
        
    }

}