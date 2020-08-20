package leetcode;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class ValidAnagram {
    /**
     * 使用HashMap计数
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isValidAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s != null && t == null) return false;
        if (s == null && t != null) return false;
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> scharMap = new HashMap<Character, Integer>();
        //计数
        for (char c : s.toCharArray()) {
            if (scharMap.containsKey(c)) {
                scharMap.put(c, scharMap.get(c) + 1);
            } else {
                scharMap.put(c, 1);
            }
        }
        //减数
        for (char c : t.toCharArray()) {
            if (scharMap.containsKey(c)) {
                int nums = scharMap.get(c);
                nums = --nums;
                scharMap.put(c, nums);
                if (nums == 0) {
                    scharMap.remove(c);
                }
            } else {
                return false;
            }
        }
        if (!scharMap.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 只包含字母的情况，用数组来做更快
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isValidAnagramSecond(String s, String t) {
        if (s == null && t == null) return true;
        if (s != null && t == null) return false;
        if (s == null && t != null) return false;
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
        }
        for (int n : arr) {
            if (n > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ccaa";
        String t = "ccac";
        boolean validAnagram = isValidAnagramSecond(s, t);
        System.out.println(validAnagram);
    }
}
