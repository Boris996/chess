public class Queen extends Bishop {
    public Queen(boolean white){
        super(white);
    }

    @Override
    public String toString(){
        if(this.isWhite()){
            return Colors.WHITE + "♕";
        }else{
            return Colors.BLACK + "♛";
        }
    }

    @Override
    public int[][] reachableSquares(Piece[][] board, int x, int y){
        int[][] result = super.reachableSquares(board,x,y);

        for(int i = x + 1; i < Chess.side; i++){
            if(board[i][y] == null) {
                result = appendToResult(result, new int[]{i, y});
            }else{
                if(!((board[i][y].isWhite() && this.isWhite()) ||
                        (!board[i][y].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{i,y});
                }
                break;
            }
        }

        for(int i = x - 1; i >= 0; i--){
            if(board[i][y] == null) {
                result = appendToResult(result, new int[]{i, y});
            }else{
                if(!((board[i][y].isWhite() && this.isWhite()) ||
                        (!board[i][y].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{i,y});
                }
                break;
            }
        }

        for(int i = y + 1; i < Chess.side; i++){
            if(board[x][i] == null) {
                result = appendToResult(result, new int[]{x, i});
            }else{
                if(!((board[x][i].isWhite() && this.isWhite()) ||
                        (!board[x][i].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{x,i});
                }
                break;
            }
        }

        for(int i = y - 1; i >= 0; i--){
            if(board[x][i] == null) {
                result = appendToResult(result, new int[]{x, i});
            }else{
                if(!((board[x][i].isWhite() && this.isWhite()) ||
                        (!board[x][i].isWhite() && !this.isWhite())))
                {
                    result = appendToResult(result,new int[]{x,i});
                }
                break;
            }
        }


        return result;
    }
}
