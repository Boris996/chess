public class Piece {
    private boolean isWhite;

    /**
     * @param white
     */
    public Piece(boolean white) {
        this.isWhite = white;
    }

    /**
     * Returns color
     * @return
     */

    public boolean isWhite() {
        return this.isWhite;
    }

    protected static int[][] appendToResult(int[][] squares, int[] square) {
        int[][] result = new int[squares.length + 1][];

        for(int i = 0; i < squares.length; i++){
            result[i] = new int[]{squares[i][0], squares[i][1]};
        }

        result[result.length - 1] = new int[]{square[0],square[1]};


        return result;
    }

    /**
     * Returns reachable squares
     * @param board
     * @param fromX
     * @param fromY
     * @return
     */
    public int[][] reachableSquares(Piece[][] board, int fromX, int fromY) {
        return null;
    }
}
