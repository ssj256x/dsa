package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class ReverseWordsInSentence {

    public static void main(String[] args) {
        ReverseWordsInSentence obj = new ReverseWordsInSentence();
        System.out.println(obj.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        for(int i = 0; i < arr.length; i++) {
            arr[i] = reverse(arr[i]);
        }

        return String.join(" ", arr);
    }

    public String reverse(String str) {
        int end = str.length() - 1;
        char temp;

        char[] strArr = str.toCharArray();

        for(int i = 0; i < strArr.length / 2; i++) {
            temp = strArr[i];
            strArr[i] = strArr[end];
            strArr[end--]= temp;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, map.getOrDefault(1, 0));

        return new String(strArr);
    }
}
