class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqCount = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            freqCount.put(nums[i], freqCount.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer> freqArray = new ArrayList<>(freqCount.keySet());
        freqArray.sort((a, b) -> freqCount.get(b) - freqCount.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = freqArray.get(i);
        }
        return result;
    }
}
