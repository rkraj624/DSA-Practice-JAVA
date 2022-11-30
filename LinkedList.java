import java.util.List;

import javax.management.loading.PrivateClassLoader;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for(int i = 1 ; i < n; i++){
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        } 
        head = addFirst(head, 0);
        head = reverseList(head);
        traverseList(head);
    }
    private static ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static ListNode addFirst(ListNode head, int val){
        if(head == null){
            return head = new ListNode(val);
        }else{
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
    private static void traverseList(ListNode head){
        while(head != null){
            System.out.print(head.val +" ");
            head = head.next;
        }
    }
}
