class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // stores indices!
        Deque<Integer> deq = new ArrayDeque<>();

        // number of windows in nums = nums.length - k + 1
        int[] result = new int[nums.length - k + 1];

        for(int r = 0; r<nums.length; r++){
            if (!deq.isEmpty() && deq.peekFirst() < r - k + 1){
                deq.removeFirst();
            }

            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[r]){
                deq.removeLast();
            }

            deq.addLast(r);

            // check if window is full
            if (r >= k - 1){
                result[r - k + 1] = nums[deq.peekFirst()];
            }
        }

        return result;
    }
}
