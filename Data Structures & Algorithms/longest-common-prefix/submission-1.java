class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String prefix_string = "";

        for (int i = 0; i < strs[0].length(); i++) {
            char current_char = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != current_char) {
                    return prefix_string;
                }
            }

            prefix_string += current_char;
        }

        return prefix_string;
    }
}