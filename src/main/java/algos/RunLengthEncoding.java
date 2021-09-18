package algos;

public class RunLengthEncoding {

    public static String runLengthEncoding(String string) {
        int pl = 0;
        StringBuilder builder = new StringBuilder();
        while(pl < string.length()) {
            int pr = pl + 1;
            int count = 1;
            int prMax = Math.min(pl + 8, pl + (string.length() - pr));
            char cur = string.charAt(pl);
            while(pr <= prMax && string.charAt(pr) == cur) {
                pr++;
                count++;
            }
            builder.append(count);
            builder.append(cur);
            pl = pr;
        }
        return builder.toString();
    }
    
}
