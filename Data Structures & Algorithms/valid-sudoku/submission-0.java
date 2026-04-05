class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        for (int i = 0; i < 9; i++) rows[i] = new HashSet<>();

        HashSet<Character>[] cols = new HashSet[9];
        for (int i = 0; i < 9; i++) cols[i] = new HashSet<>();

        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) boxes[i] = new HashSet<>();

        for (int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if (board[i][j]!='.'){
                    if (rows[i].contains(board[i][j]) || cols[j].contains(board[i][j]) || boxes[(i/3)*3 + (j/3)].contains(board[i][j])){
                        return false;
                    }

                    rows[i].add(board[i][j]);
                    cols[j].add(board[i][j]);
                    boxes[(i/3)*3 + (j/3)].add(board[i][j]);
                }
            }
        }
        return true;
    }
}
