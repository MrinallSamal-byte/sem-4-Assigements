import java.util.HashMap;

public class Q8 {

    static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {
            {"listen", "silent"},
            {"hello",  "world"},
            {"triangle", "integral"},
            {"abc", "cab"}
        };

        System.out.println("=".repeat(40));
        System.out.printf("%-12s %-12s %s%n", "String 1", "String 2", "Anagram?");
        System.out.println("=".repeat(40));

        for (String[] pair : pairs) {
            System.out.printf("%-12s %-12s %s%n",
                pair[0], pair[1], areAnagrams(pair[0], pair[1]) ? "Yes ✓" : "No ✗");
        }

        System.out.println("=".repeat(40));
    }
}