import java.util.Arrays;

public class Pawn extends Piece{

    private int[] passingPawn;

    public Pawn(boolean white){
        super(white);
    }

    @Override
    public String toString() {
        if(this.isWhite()){
            return Colors.WHITE + "♙";
        } else {
            return Colors.BLACK + "♟";
        }
    }

    @Override
    public int[][] reachableSquares(Piece[][] board, int fromX, int fromY) {
        int[][] result = new int[0][0];

        if(isWhite()){
            if(board[fromX - 1][fromY] == null){
                result = appendToResult(result, new int[]{fromX - 1, fromY});
                if(fromX == 6 && board[fromX - 2][fromY] == null){
                    result = appendToResult(result, new int[]{fromX - 2, fromY});
                }
            }

            if(fromY > 0 && board[fromX - 1][fromY - 1] != null && !board[fromX - 1][fromY - 1].isWhite()){
                result = appendToResult(result, new int[]{fromX - 1, fromY - 1});
            }

            if(fromY < Chess.side - 1 && board[fromX - 1][fromY + 1] != null && !board[fromX - 1][fromY + 1].isWhite()){
                result = appendToResult(result, new int[]{fromX - 1, fromY + 1});
            }
        } else{
            if(board[fromX + 1][fromY] == null){
                result = appendToResult(result, new int[]{fromX+1, fromY});
                if(fromX == 1 && board[fromX + 2][fromY] == null){
                    result = appendToResult(result, new int[]{fromX+2, fromY});
                }
            }

            if(fromY > 0 && board[fromX + 1][fromY - 1] != null && board[fromX + 1][fromY - 1].isWhite()){
                result = appendToResult(result, new int[]{fromX + 1, fromY - 1});
            }

            if(fromY < Chess.side - 1 && board[fromX + 1][fromY + 1] != null && board[fromX + 1][fromY + 1].isWhite()){
                result = appendToResult(result, new int[]{fromX + 1, fromY+1});
            }
        }

        return result;
    }

    public void setPassingPawn(int x, int y){
        this.passingPawn = new int[]{x, y};
    }

    public void setPassingPawn(){
        this.passingPawn = null;
    }
}
