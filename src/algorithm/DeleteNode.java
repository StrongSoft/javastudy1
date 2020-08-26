package algorithm;

public class DeleteNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head, cur = head;
        int size = 0, check = 0;

        while (cur != null){
            cur = cur.next;
            size++;
        }

        if(size == 0) {
            start = start.next;
            return start;
        }

        size -= n;
        while (start != null){
            check += 1;
            if (check == size){
                start.next = start.next.next;
                return head;
            }
            start = start.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
