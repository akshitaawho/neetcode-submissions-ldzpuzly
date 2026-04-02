class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> sumNums = new HashMap<>();

        for (int i = 0; i<nums.length; i++){
            int complement = target - nums[i];
            if (sumNums.containsKey(complement)){
                return new int[] {sumNums.get(complement), i};
            }

            sumNums.put(nums[i], i);
        
        }
        return new int[]{};
    }
}
