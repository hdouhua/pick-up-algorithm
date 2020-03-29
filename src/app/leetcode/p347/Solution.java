package app.leetcode.p347;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Solution
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Solution {
    private class Frequency implements Comparable<Frequency> {

        public int number;
        public int count;

        public Frequency(int num, int count) {
            this.number = num;
            this.count = count;
        }

        @Override
        public int compareTo(Frequency o) {
            if (this.count > o.count) {
                return 1;
            }
            if (this.count < o.count) {
                return -1;
            }
            return 0;
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Frequency> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new Frequency(key, map.get(key)));
            } else if (map.get(key) > queue.peek().count) {
                queue.remove();
                queue.add(new Frequency(key, map.get(key)));
            }
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!queue.isEmpty()) {
            linkedList.add(queue.remove().number);
        }

        return linkedList;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, -1, 2, -1, 2, 3 };
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
}