
public class DS1290 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int result = head.val;
        while (head.next != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        DS1290 ds1290 = new DS1290();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(ds1290.getDecimalValue(head)); // Output: 5
    }

}
