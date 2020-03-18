package app.leetcode.p203;

import app.leetcode.shared.*;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        while(head!=null && head.val == val) {
            head = head.next;
        }
        if(head == null) {
            return head;
        }
        ListNode node = head;
        while(node.next!=null) {
            if(node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public ListNode removeElements3(ListNode head, int val, int depth) {
        String depthString = getDepthString(depth);
        System.out.println(String.format("%sCall: remove %d in %s",depthString, val, head));

        if(head == null) {
            System.out.println(depthString + "Return: null");
            return null;
        }

        // ListNode remaining = removeElements3(head.next, val);
        // if (head.val == val) {
        //     return remaining;
        // } else {
        //     head.next = remaining;
        //     return head;
        // }
        //=>
        // head.next = removeElements3(head.next, val, 0);
        // return head.val == val ? head.next : head;

        ListNode remaining = removeElements3(head.next, val, depth + 1);
        System.out.println(String.format("%sAfter remove %d: %s", depthString, val, head));

        if (head.val == val) {
            System.out.println(depthString +  "Return: " + remaining);
            return remaining;
        } else {
            head.next = remaining;
            System.out.println(depthString + "Return: " + head);
            return head;
        }
    }

    private String getDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        // ListNode result = new Solution().removeElements(head, 5);
        // System.out.println(result);

        // result = new Solution().removeElements2(head, 5);
        // System.out.println(result);

        ListNode result = new Solution().removeElements3(head, 5, 0);
        System.out.println(result);
    }
}