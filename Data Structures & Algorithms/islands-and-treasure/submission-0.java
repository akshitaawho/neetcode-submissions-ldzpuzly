class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        final int INF = Integer.MAX_VALUE;

        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if (r+1 < grid.length && grid[r+1][c] == INF){
                grid[r+1][c] = grid[r][c] + 1;
                queue.offer(new int[]{r+1, c});
            }

            if (c+1<grid[0].length && grid[r][c+1] == INF){
                grid[r][c+1] = grid[r][c] + 1;
                queue.offer(new int[]{r, c+1});
            }

            if (r-1>=0 && grid[r-1][c] == INF){
                grid[r-1][c] = grid[r][c] + 1;
                queue.offer(new int[]{r-1, c});
            }

            if (c - 1>=0 && grid[r][c-1] == INF){
                grid[r][c-1] = grid[r][c] +1;
                queue.offer(new int[]{r, c-1});
            }
        }
    }
}
