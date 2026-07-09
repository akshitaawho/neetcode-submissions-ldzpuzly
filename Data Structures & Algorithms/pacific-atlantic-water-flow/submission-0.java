class Solution {
    private void dfs(int[][]heights, int r, int c, boolean[][] visited){
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length || visited[r][c]){
            return;
        }

        visited[r][c] = true;

        if (r+1<heights.length && !visited[r+1][c] && heights[r][c]<=heights[r+1][c]){
            dfs(heights, r+1, c, visited);
        }

        if (c+1<heights[0].length && !visited[r][c+1] && heights[r][c] <= heights[r][c+1]){
            dfs(heights, r, c+1, visited);
        }

        if (r-1>=0 && !visited[r-1][c] && heights[r][c] <= heights[r-1][c]){
            dfs(heights, r-1, c, visited);
        }

        if (c-1>=0 && !visited[r][c-1] && heights[r][c] <= heights[r][c-1]){
            dfs(heights, r, c-1, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> answer = new ArrayList<>();

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        for (int r = 0; r<rows; r++){
            dfs(heights, r, 0, pacific);
        }
        for (int c = 0; c<cols; c++){
            dfs(heights, 0, c, pacific);
        }

        for (int r = 0; r<rows; r++){
            dfs(heights, r, cols-1, atlantic);
        }
        for (int c = 0; c<cols; c++){
            dfs(heights, rows-1, c, atlantic);
        }
        
        for (int r = 0; r<rows; r++){
            for (int c = 0; c<cols; c++){
                if (pacific[r][c] && atlantic[r][c]){
                    answer.add(Arrays.asList(r, c));
                }
            }
        }

        return answer;
    }
}
