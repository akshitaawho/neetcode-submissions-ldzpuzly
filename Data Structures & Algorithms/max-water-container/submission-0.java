class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int volume = 0;
        int maxvolume = 0;

        for (int i = 0; i<heights.length; i++){
            volume = Math.min(heights[left], heights[right]) * (right - left);

            if (heights[left]<heights[right]){
                left ++;
            }
            else if (heights[left] >= heights[right]){
                right--;
            }

            maxvolume = Math.max(maxvolume, volume);
        }

        return maxvolume;
    }
}
