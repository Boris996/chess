public class King extends Piece {
    private boolean hasMoved;

    public King(boolean white){
        this(white,false);
    }

    public King(boolean white, boolean hasMoved){
        super(white);
        this.hasMoved = hasMoved;
    }

    @Override
    public String toString(){
        if(this.isWhite()){
            return Colors.WHITE + "♔";
        } else {
            return Colors.BLACK + "♚";
        }
    }
}
