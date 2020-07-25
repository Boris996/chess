import java.util.Scanner;

public class Chess {
    Piece[][] board;

    protected static final int side = 8;

    public Chess() {
        this("24232225262223242121212121212121000000000000000000000000000000000000000000000000000000000000000011111111111111111413121516121314");
    }

    public Chess(String string) {
        board = new Piece[side][side];
        this.drawBoardWithPieces(string);
    }

    protected void drawBoardWithPieces(String string) {
        int index = 0;
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board.length; ++j) {
                char firstCharacter = string.charAt(index);
                char secondCharacter = string.charAt(index + 1);
                if(firstCharacter != '0' && secondCharacter != '0') {
                    Piece piece = getPiece(firstCharacter, secondCharacter);
                    board[i][j] = piece;
                }
                index += 2;
            }
        }
    }

    /**
     * Core loop of program
     */
    public void play() {
        Scanner sc = new Scanner(System.in);
        int turn = 0;
        boolean gameNotFinished = true;
        String[] userInput;

        print();

        while(gameNotFinished) {
            if(turn % 2 == 0) {
                System.out.print("White's move:");
            } else {
                System.out.print("Black's move:");
            }

            userInput = sc.nextLine().toLowerCase().split(" ");
            System.out.println();

            if(userInput.length == 1) {
                int[] sourceCoords = squareToCoords(userInput[0]);
                print(sourceCoords[0],sourceCoords[1]);
            } else {
                if(userInput.length == 2){
                    int[] sourceCoords = squareToCoords(userInput[0]);
                    int[] destCoords = squareToCoords(userInput[1]);

                    if(isSquareReachable(sourceCoords[0],sourceCoords[1],
                            destCoords[0],destCoords[1])) {
                        Piece piece = board[sourceCoords[0]][sourceCoords[1]];

                        System.out.println(piece.equals(new King(true)));

                        board[destCoords[0]][destCoords[1]] = piece;
                        board[sourceCoords[0]][sourceCoords[1]] = null;
                        turn++;
                    } else {
                        System.out.println(" Unreachable Square ");
                    }
                    print();
                }
            }
        }
    }

    /**
     * Checks if square is reachable or not
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return
     */
    public boolean isSquareReachable(int fromX, int fromY, int toX, int toY) {
        Piece piece = board[fromX][fromY];
        if(piece != null) {
            int[][] reachableSquares = piece.reachableSquares(board, fromX, fromY);
            if(isReachable(reachableSquares, toX, toY)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the board and the pieces on it
     */
    public void print() {
        boolean black = true;
        String currentColor;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; ++j) {
                Piece piece = board[i][j];
                currentColor = black ? Colors.BACKGROUND_BLACK : Colors.BACKGROUND_WHITE;;
                String block = currentColor + "   ";
                if (piece != null) {
                    block = currentColor + " " + piece+" ";
                }
                System.out.print(block + Colors.INITIAL_COLOR);
                black = !black;
            }
            System.out.println(" ");
            black = !black;
        }
        System.out.println("   A  B  C  D  E  F  G  H ");
    }

    /**
     * Prints Piece and hightlights reachable squares
     * @param fromX
     * @param fromY
     */
    public void print(int fromX, int fromY) {
        boolean black = true;
        String currentColor;
        Piece piece = board[fromX][fromY];
        if(piece == null) {
            System.out.println("There is no piece on that coordinate");
            return;
        }

        String red = Colors.BACKGROUND_BRIGHT_RED;
        int[][] reachableSquares = piece.reachableSquares(board, fromX, fromY);
        String block;
        Piece currentPiece;

        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; ++j) {
                currentColor = black ? Colors.BACKGROUND_BLACK : Colors.BACKGROUND_WHITE;
                currentPiece = board[i][j];
                block = currentColor + "   ";

                if(currentPiece != null) {
                    block = currentColor + " " + currentPiece+" ";
                }
                if(isReachable(reachableSquares, i, j)) {
                    block = red + (currentPiece != null ? ""+currentPiece+"" : "   ");
                }

                System.out.print(block + Colors.INITIAL_COLOR);
                black = !black;
            }
            System.out.println("");
            black = !black;
        }
    }

    public int[] squareToCoords(String s){
        return new int[] {56  - s.charAt(1), s.charAt(0) - 97};
    }

    /**
     * Returns if single square is reachable or not
     * @param reachableSquares
     * @param toX
     * @param toY
     * @return
     */
    public boolean isReachable(int[][] reachableSquares, int toX, int toY) {
        for(int i = 0; i < reachableSquares.length; ++i) {
            int[] current = reachableSquares[i];
            if(current[0] == toX && current[1] == toY) {
                return true;
            }
        }
        return false;
    }


    private Piece getPiece(char first, char second) {
        boolean isWhite = first == '1';
        switch (second) {
            case '1':
                return new Pawn(isWhite);
            case '2':
                return new Bishop(isWhite);
            case '3':
                return new Knight(isWhite);
            case '4':
            case '7':
                return new Rook(isWhite);
            case '5':
                return new Queen(isWhite);
            case '6':
            case '8':
                return new King(isWhite);
            default:
                return null;
        }
    }
}
