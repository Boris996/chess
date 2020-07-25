public class Rook extends Piece {

    private boolean hasMoved;

    public Rook(boolean white){
        this(white,false);
    }

    public Rook(boolean white, boolean hasMoved){
        super(white);
        this.hasMoved = hasMoved;
    }

    public void setMoved(){
        this.hasMoved = true;
    }

    @Override
    public String toString() {
        if(this.isWhite()){
            return Colors.WHITE + "♖";
        } else{
            return Colors.BLACK + "♜";
        }
    }

    @Override
    public int[][] reachableSquares(Piece[][] board, int fromX, int fromY) {
        int[][] result = new int[0][0];

        for(int i = fromX + 1; i < Chess.side; i++){
            if(board[i][fromY] == null) {
                result = appendToResult(result, new int[]{i, fromY});
            } else {
                if(!((board[i][fromY].isWhite() && this.isWhite()) ||
                        (!board[i][fromY].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{i, fromY});
                }
                break;
            }
        }

        for(int i = fromX - 1; i >= 0; i--){
            if(board[i][fromY] == null) {
                result = appendToResult(result, new int[]{i, fromY});
            }else{
                if(!((board[i][fromY].isWhite() && this.isWhite()) ||
                        (!board[i][fromY].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{i, fromY});
                }
                break;
            }
        }

        for(int i = fromY + 1; i < Chess.side; i++){
            if(board[fromX][i] == null) {
                result = appendToResult(result, new int[]{fromX, i});
            }else{
                if(!((board[fromX][i].isWhite() && this.isWhite()) ||
                        (!board[fromX][i].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{fromX, i});
                }
                break;
            }
        }

        for(int i = fromY - 1; i >= 0; i--){
            if(board[fromX][i] == null) {
                result = appendToResult(result, new int[]{fromX, i});
            }else{
                if(!((board[fromX][i].isWhite() && this.isWhite()) ||
                        (!board[fromX][i].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{fromX, i});
                }
                break;
            }
        }

        return result;
    }
}
