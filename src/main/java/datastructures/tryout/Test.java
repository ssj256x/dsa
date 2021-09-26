package datastructures.tryout;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String s = "ababcbacadefegdehijhklij";

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        System.out.println(map);
    }
}
