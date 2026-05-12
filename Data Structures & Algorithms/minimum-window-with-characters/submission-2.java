class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        int need = tMap.size();
        int have = 0;
        int l = 0;

        int minLen = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;

        for (int r = 0; r<s.length(); r++){
            //char c = s.charAt(r)
            //current window size = r - l - 1
            windowMap.put(s.charAt(r), windowMap.getOrDefault(s.charAt(r), 0)+1);

            if (tMap.containsKey(s.charAt(r)) && windowMap.get(s.charAt(r)).equals(tMap.get(s.charAt(r)))){
                have++;
            }

            while (have == need) {
                // step 1: check if window length is less than the minimum, and update the variable values
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    leftIndex = l;
                    rightIndex = r;
                }

                // step 2: remove the left side charachter
                windowMap.put(s.charAt(l), windowMap.get(s.charAt(l)) - 1);
                
                if(tMap.containsKey(s.charAt(l)) && windowMap.get(s.charAt(l)) < (tMap.get(s.charAt(l)))){
                    have--;
                }
                l++;

                if (minLen == Integer.MAX_VALUE){
                    return "";
                }

            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(leftIndex, rightIndex + 1);

    }
}
