package algorithms.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        float[] a = {
                (float) 0.897,
                (float) 0.565,
                (float) 0.656,
                (float) 0.1234,
                (float) 0.665,
                (float) 0.3434
        };

        new BucketSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @SuppressWarnings("unchecked")
    public void sort(float[] a) {
        int n = a.length;
        List<Float>[] buckets = new List[n];
        Arrays.fill(buckets, new LinkedList<>());

        for (float v : a) {
            float idx = (n * v);
            buckets[(int) idx].add(v);
        }

        for (List<Float> l : buckets)
            Collections.sort(l);

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                a[index++] = buckets[i].get(j);
            }
        }
    }
}
