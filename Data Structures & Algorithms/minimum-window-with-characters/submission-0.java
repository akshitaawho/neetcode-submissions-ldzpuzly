class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int need = tmap.size();
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (tmap.containsKey(c) && windowMap.get(c).equals(tmap.get(c))) {
                have++;
            }

            while (have == need) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minL = l;
                    minR = r;
                }

                char leftChar = s.charAt(l);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (tmap.containsKey(leftChar) && windowMap.get(leftChar) < tmap.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }
}