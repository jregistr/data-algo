package algos;

// f
public class RotatingCipher {
    static String lowerAlph = "abcdefghijklmnopqrstuvwxyz";
   static String upperAlph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String nums = "0123456789";

    public static String rotationalCipher(String input, int rotationFactor) {
        StringBuilder builder = new StringBuilder();

        for(char current : input.toCharArray()) {
            int index;
            String alphabet = null;

            int charToNum = (int) current;
            //uppercase char
            if(charToNum >= 65 && charToNum <= 90) {
                index = upperAlph.indexOf(current);
                alphabet = upperAlph;
            } else if(charToNum >= 97 && charToNum <= 122) {
                index = lowerAlph.indexOf(current);
                alphabet = lowerAlph;
            } else if(charToNum >= 48 && charToNum <= 57) {
                index = nums.indexOf(current);
                alphabet = nums;
            } else {
                index = -1;
            }

            if(index < 0) {
                builder.append(current);
            } else {
                int newIndex = (index + rotationFactor) % alphabet.length();
                char newChar = alphabet.charAt(newIndex);
                builder.append(newChar);
            }
        }

        return builder.toString();
    }
}
