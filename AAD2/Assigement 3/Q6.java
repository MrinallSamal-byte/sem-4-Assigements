import java.util.HashSet;
import java.util.LinkedHashSet;

public class Q6 {
    public static void main(String[] args) {
        String input = "programming";

        LinkedHashSet<Character> seen = new LinkedHashSet<>();

        for (char c : input.toCharArray()) {
            seen.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : seen) {
            result.append(c);
        }

        System.out.println("Original String : " + input);
        System.out.println("After Removing Duplicates : " + result);
    }
}