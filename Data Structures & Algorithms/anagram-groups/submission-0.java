class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> anagramList = new HashMap<>();

        for (int i = 0; i<strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!anagramList.containsKey(sorted)){
                anagramList.put(sorted, new ArrayList<>());
            }

            anagramList.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(anagramList.values());
    }
}
