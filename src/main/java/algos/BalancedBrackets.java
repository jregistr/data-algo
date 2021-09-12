package algos;
import java.util.*;

public class BalancedBrackets {

    boolean isBalanced(String s) {
        Map<Character, Character> opMap = opposites();
        Set<Character> opens = new HashSet<>(Arrays.asList('{', '[', '('));
        // Write your code here
        Deque<Character> deq = new ArrayDeque<>();
        for(char current : s.toCharArray()) {
            if(opens.contains(current)) {
                deq.push(current);
            } else {
                Character peeked = deq.peek();
                if(peeked == null) return false;
                Character openVersion = opMap.get(current);
                if(openVersion != peeked) return false;
                deq.pop();
            }
        }
        return deq.peek() == null;
    }

    private Map<Character, Character> opposites() {
        Map<Character, Character> res = new HashMap<>();
        res.put('}', '{');
        res.put(']', '[');
        res.put(')', '(');
        return res;
    }
}
