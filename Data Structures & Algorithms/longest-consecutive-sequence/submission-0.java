class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> intSet = new HashSet<>();

        for (int val : nums){
            intSet.add(val);
        }

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i<nums.length; i++){
            if (!intSet.contains(nums[i]-1)){
                count = 0;
            }
            count = 1;
            while (intSet.contains(nums[i] + 1)){
                nums[i] += 1;
                count += 1;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
