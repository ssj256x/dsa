package algorithms.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElement {

    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {

        if(k == nums.length) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for(int n : map.keySet()) {
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }

        for(int i = 0; i < k; i++)
            ans[i] = heap.poll();

        return ans;
    }
}
