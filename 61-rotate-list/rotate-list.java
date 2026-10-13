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
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        int len=1;
        ListNode tail=head;
        while(tail.next!=null)
        {
            len++;
            tail=tail.next;
        }
        if(k%len==0) return head;
        k=k%len;
        if(k==0) {
            return head;
        }
        tail.next=head;
        ListNode newnode=findNthnode(head,len-k);
        head=newnode.next;
        newnode.next=null;
        return head;
    }
    private ListNode findNthnode(ListNode temp,int k)
    {
        int c=1;
        while(c<k)
        {
            if(c==k) return temp;
            c++;
            temp=temp.next;
        }
        return temp;
    }
}