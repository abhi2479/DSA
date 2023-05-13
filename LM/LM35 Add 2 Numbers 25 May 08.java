You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input Format

Integer N, size of first linked list. N element for first linked list. Integer M, size of second linked list. M element for second linked list.

Constraints

1 <= N <= 104
Output Format

Linked list node, of integer data-type.

Sample Input 0

3
2
4
3
3
5
6
4
Sample Output 0

7 0 8
Sample Input 1

3
3
2
4
3
2
3
2
Sample Output 1

5 5 6


public static SinglyLinkedListNode addNumbers(SinglyLinkedListNode s1, SinglyLinkedListNode s2) {


    SinglyLinkedListNode result = null, head = null;
    int carry = 0;
    
    s1 = reverse(s1);
    s2 = reverse(s2);

    while (s1 != null || s2 != null) {
      int sum = 0;
      if (s1 != null) {
        sum += s1.data;
        s1 = s1.next;
      }

      if (s2 != null) {
        sum += s2.data;
        s2 = s2.next;
      }
  
      sum += carry;

      int value = sum % 10;
      carry = sum / 10;
        
      SinglyLinkedListNode node = new SinglyLinkedListNode(value);
      if (result != null) {
        result.next = node;
        result = result.next;
      } else {
        result = head = node; 
      }
    }

    if (carry > 0) {
      result.next = new SinglyLinkedListNode(carry);

    }

    head = reverse(head);
    return head;
        
    }

    
    
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode node)
    {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = node;
        SinglyLinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
