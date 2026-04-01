class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        char[] s_arr = new char[s.length()];
        char[] t_arr = new char[t.length()];

        for (int i = 0; i < s.length(); i++) {
            s_arr[i] = s.charAt(i);
            t_arr[i] = t.charAt(i);
        }
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);

        return Arrays.equals(s_arr, t_arr);
    }
}
