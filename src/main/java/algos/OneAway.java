package algos;

public class OneAway {
    public static Boolean isOneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        if (s1.length() == s2.length()) {
            return oneAwayForSameLength(s1, s2);
        } else {
            return oneAwayDiffLengths(s1, s2);
        }
    }

    private static boolean oneAwayForSameLength(String s1, String s2) {
        int diffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs++;
            }

            if (diffs > 1) return false;
        }
        return true;
    }

    private static boolean oneAwayDiffLengths(String s1, String s2) {
        String smaller, bigger;
        if (s1.length() > s2.length()) {
            bigger = s1;
            smaller = s2;
        } else {
            bigger = s2;
            smaller = s1;
        }

        int i = 0;
        int diff = 0;
        while (i < smaller.length()) {
            if (bigger.charAt(i + diff) == smaller.charAt(i)) {
                i++;
            } else {
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }
}
