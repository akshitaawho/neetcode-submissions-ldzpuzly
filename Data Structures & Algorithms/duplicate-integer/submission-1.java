
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        
        for (int num : nums){
            numberSet.add(num);
        }

        return nums.length > numberSet.size();

    }
}