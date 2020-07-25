import java.util.Arrays;

public class Bishop extends Piece {

    /**
     * Constructor for the Bishop class
     * @param white
     */
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public int[][] reachableSquares(Piece[][] board, int fromX, int fromY) {
        // 4 cases
        int[][] reachableSquares = new int[16][2];

        // case 1
        int tempX1 = fromX  + 1;
        int tempX2 = fromY - 1;
        int index = 0;
        for(int i = 0; i <= 7; ++i) {
            if (this.reachedToPieceWithSameColor(board, tempX1, tempX2)) {
                break;
            }
            reachableSquares[index][0] = tempX1;
            reachableSquares[index][1] = tempX2;
            index++;
            if(this.reachedToPieceWithDifferentColor(board, tempX1, tempX2)) {
                break;
            }
            tempX1++;
            tempX2--;
        }

        tempX1 = fromX - 1;
        tempX2 = fromY + 1;
        // case 2
        for(int i = 0; i <= 7; ++i) {
            if(this.reachedToPieceWithSameColor(board, tempX1, tempX2)) {
                break;
            }
            reachableSquares[index][0] = tempX1;
            reachableSquares[index][1] = tempX2;
            index++;
            if(this.reachedToPieceWithDifferentColor(board, tempX1, tempX2)) {
                break;
            }
            tempX1--;
            tempX2++;
        }

        tempX1 = fromX - 1;
        tempX2 = fromY - 1;
        // case 3
        for(int i = 0; i <= 7; ++i) {
            if(this.reachedToPieceWithSameColor(board, tempX1, tempX2)) {
                break;
            }
            reachableSquares[index][0] = tempX1;
            reachableSquares[index][1] = tempX2;
            index++;
            if(this.reachedToPieceWithDifferentColor(board, tempX1, tempX2)) {
                break;
            }
            tempX1--;
            tempX2--;
        }

        // case 4
        tempX1 = fromX + 1;
        tempX2 = fromY + 1;
        for(int i = 0; i <= 7; ++i) {
            if(this.reachedToPieceWithDifferentColor(board, tempX1, tempX2)) {
                break;
            }
            reachableSquares[index][0] = tempX1;
            reachableSquares[index][1] = tempX2;
            index++;
            if(this.reachedToPieceWithDifferentColor(board, tempX1, tempX2)) {
                break;
            }
            tempX1++;
            tempX2++;
        }
        return Arrays.copyOfRange(reachableSquares, 0, index);
    }


    @Override
    public String toString() {
        boolean white = isWhite();
        String bishop = "";
        if(!white) {
            bishop = Colors.BLACK + "♝";
        } else {
            bishop = Colors.WHITE + "♗";
        }
        return bishop;
    }

    /**
     * Checks if reached to the piece with same color or detects size of side exceeding
     * @param board
     * @param i
     * @param j
     * @return
     */
    private boolean reachedToPieceWithSameColor(Piece[][] board, int i, int j) {
        Piece piece;
        try {
            piece = board[i][j];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return true;
        }
        return piece != null && piece.isWhite() == this.isWhite();
    }

    /**
     * Checks if reached to the piece with different color or detects size of side exceeding
     * @param board
     * @param i
     * @param j
     * @return
     */
    private boolean reachedToPieceWithDifferentColor(Piece board[][], int i, int j) {
        Piece piece;
        try {
            piece = board[i][j];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return true;
        }
        return piece != null && piece.isWhite() != this.isWhite();
    }
}
