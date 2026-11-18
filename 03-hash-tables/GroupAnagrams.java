import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hash Table: Group Anagrams
 *
 * Problem: Group the strings that are anagrams of each other (same letters, any order).
 * Pattern: Canonical key in a hash map.
 * Time: O(n * k log k), where k is the longest string | Space: O(n * k)
 *
 * Insight: Sorting the characters of a word gives the same key for all of its anagrams
 *          ("eat", "tea", "ate" -> "aet"). Group the words by that key.
 *          Counting letters instead of sorting brings the key cost down to O(k).
 */
public class GroupAnagrams {

    static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});

        check(result.size() == 3, "three groups");
        check(contains(result, "eat", "tea", "ate"), "eat/tea/ate");
        check(contains(result, "tan", "nat"), "tan/nat");
        check(contains(result, "bat"), "bat");
        check(groupAnagrams(new String[] {}).isEmpty(), "empty input");

        System.out.println("GroupAnagrams: all checks passed");
    }

    private static boolean contains(List<List<String>> groups, String... expected) {
        List<String> want = Arrays.asList(expected);
        for (List<String> g : groups) {
            List<String> sorted = new ArrayList<>(g);
            java.util.Collections.sort(sorted);
            List<String> w = new ArrayList<>(want);
            java.util.Collections.sort(w);
            if (sorted.equals(w)) return true;
        }
        return false;
    }

    private static void check(boolean ok, String name) {
        if (!ok) throw new AssertionError("FAILED: " + name);
    }
}
