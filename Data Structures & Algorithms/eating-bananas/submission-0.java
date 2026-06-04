class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l <= r){
            int mid = (l + r)/2;
            int totalHours = 0;

            for (int pile : piles){
                totalHours += (pile + mid - 1)/mid;
            }

            if (totalHours <= h){
                r = mid - 1;
            }

            else if (totalHours > h){
                l = mid + 1;
            }
        }

        return l;

    }
}
