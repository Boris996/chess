import java.util.Arrays;

public class Knight extends Piece {

    /**
     * Constructor for the Knight class
     * @param isWhite
     */
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public int[][] reachableSquares(Piece[][] board, int fromX, int fromY) {
        int[][] squares = new int[8][2];
        int firstPosition = fromX - 2;
        int index = 0;

        Piece piece;
        if(firstPosition > 0) {
            if(fromY - 1 > 0) {
                piece = board[firstPosition][fromY - 1];
                if(this.hasPermission(piece)) {
                    squares[index][0] = firstPosition;
                    squares[index][1] = fromY - 1;
                    index++;
                }
            }

            if(fromY + 1 < 8) {
                piece = board[firstPosition][fromY + 1];
                if(this.hasPermission(piece)) {
                    squares[index][0] = firstPosition;
                    squares[index][1] = fromY + 1;
                    index++;
                }
            }
        }

        // secondPosition
        int secondPosition = fromX - 1;
        if(secondPosition > 0) {
            if (fromY - 2 > 0) {
                piece = board[secondPosition][fromY - 2];
                if (this.hasPermission(piece)) {
                    squares[index][0] = secondPosition;
                    squares[index][1] = fromY - 2;
                    index++;
                }
            }

            if (fromY + 2 < 8) {
                piece = board[secondPosition][fromY + 2];
                if (this.hasPermission(piece)) {
                    squares[index][0] = secondPosition;
                    squares[index][1] = fromY + 2;
                    index++;
                }
            }
        }

        int thirdPosition = fromX + 1;
        if (thirdPosition < 8) {
            if (fromY - 2 > 0) {
                piece = board[thirdPosition][fromY - 2];
                if (this.hasPermission(piece)) {
                    squares[index][0] = thirdPosition;
                    squares[index][1] = fromY - 2;
                    index++;
                }
            }
            if (fromY + 2 < 8) {
                piece = board[thirdPosition][fromY + 2];
                if (this.hasPermission(piece)) {
                    squares[index][0] = thirdPosition;
                    squares[index][1] = fromY + 2;
                    index++;
                }
            }
        }

        // fourthPosition
        int fourthPosition = fromX + 2;
        if (fourthPosition < 8) {
            if (fromY - 1 > 0) {
                piece = board[fourthPosition][fromY - 1];
                if (this.hasPermission(piece)) {
                    squares[index][0] = fourthPosition;
                    squares[index][1] = fromY - 1;
                    index++;
                }
            }
            if (fromY + 1 < 8) {
                piece = board[fourthPosition][fromY + 1];
                if (this.hasPermission(piece)) {
                    squares[index][0] = fourthPosition;
                    squares[index][1] = fromY + 1;
                    index++;
                }
            }
        }
        return Arrays.copyOfRange(squares, 0, index);
    }

    @Override
    public String toString() {
        boolean isWhite = isWhite();
        String knightColor = "";
        if(!isWhite) {
            knightColor = Colors.BLACK + "♞";
        } else {
            knightColor = Colors.WHITE + "♘";
        }
        return knightColor;
    }

    /**
     * Helper method which checks if knight has permission to be inside of that square or not
     * @param piece
     * @return
     */
    private boolean hasPermission(Piece piece) {
        return piece == null || piece.isWhite() != this.isWhite();
    }
}
