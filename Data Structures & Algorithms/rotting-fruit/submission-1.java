class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int minutes = 0;

        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if (fresh == 0){
            return 0;
        }

        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for (int i = 0; i<size; i++){
                int[] rottencell = queue.poll();
                int r = rottencell[0];
                int c = rottencell[1];

                if (r+1<grid.length && grid[r+1][c] == 1){
                    grid[r+1][c] = 2;
                    fresh--;
                    queue.offer(new int[]{r+1, c});
                }

                if (c+1<grid[0].length && grid[r][c+1] == 1){
                    grid[r][c+1] = 2;
                    fresh--;
                    queue.offer(new int[]{r, c+1});
                }

                if (r-1>=0 && grid[r-1][c] == 1){
                    grid[r-1][c] = 2;
                    fresh--;
                    queue.offer(new int[]{r-1, c});
                }

                if (c-1>=0 && grid[r][c-1] == 1){
                    grid[r][c-1] = 2;
                    fresh--;
                    queue.offer(new int[]{r, c-1});
                }
            }
            minutes++;

        }

        if (fresh == 0){
            return minutes;
        }

        else{
            return -1;
        }
    }
}