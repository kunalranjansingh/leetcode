/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode add(ListNode l1, ListNode l2 , int carry){
        if (l1 == null && l2 == null && carry == 0){
            return null;
        }
        int sum = carry;
        if (l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }

        if(l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }

        int digit = sum % 10;
        carry = sum / 10;

        ListNode dummy = new ListNode (digit);
        dummy.next = add(l1, l2 , carry);

        return dummy;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return add(l1, l2 ,0);
        // ListNode result = new ListNode(0);
        // ListNode dummy = result;

        // int carry = 0;

        // while(l1 != null || l2 != null){

        //     int sum = 0 + carry;

        //     if(l1 != null){
        //         sum += l1.val;
        //         l1=l1.next;
        //     }
        //     if(l2 != null){
        //         sum += l2.val;
        //         l2 = l2.next;
        //     }
        //     carry = sum / 10;
        //     sum = sum % 10;

        //     dummy.next = new ListNode(sum);
        //     dummy = dummy.next;
        // }
        // if(carry == 1){
        //     dummy.next = new ListNode(1);
            
        // }
        // return result.next;
    }
}