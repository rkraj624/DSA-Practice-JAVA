class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class Linked_List {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        ListNode head = new ListNode(arr[0]); // head of Linked List
        ListNode tail = head; // tail pointer for inserting in O(1)
        for(int i = 1 ; i < n; i++){
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        } 
        head = addFirst(head, 0); // add a New Node to first
        head = reverseList(head); // Reverse the List
        traverseList(head); // Traverse the List
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
        // if root happens to be null return a new ListNode
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
