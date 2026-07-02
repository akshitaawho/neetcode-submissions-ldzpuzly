class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        int[][] result = new int[k][2];

        for (int i = 0; i<points.length; i++){
            minHeap.add(points[i]);
        }

        for (int j = 0; j < k; j++) {
            result[j] = minHeap.poll();
        }

        return result;
    }
}
