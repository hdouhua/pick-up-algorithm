package app.leetcode.shared;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalAccessError("nums cannot be empty");
        }

        this.val = nums[0];
        ListNode prev = this;
        for (int i = 1; i < nums.length; i++) {
                prev.next = new ListNode(nums[i]);
                prev = prev.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode node = this;
        while(node != null) {
            sb.append(node.val + " -> ");
            node = node.next;
        }
        sb.append("NULL");

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode node = new ListNode(nums);
        System.out.println(node);
    }
}
