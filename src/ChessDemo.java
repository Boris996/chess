import java.io.FileInputStream;
import java.util.Scanner;

public class ChessDemo {

    public static void main(String[] args) {
        // drawFromFile(args);

        Chess chess = new Chess();
        chess.play();

    }

    /**
     * Takes the file path from the argument and draws board based on data
     * @param args
     */
    private static void drawFromFile(String[] args) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(args[0]));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(0);
        }

        drawBoard(inputStream.nextLine(), inputStream.nextLine());
        drawBoard(inputStream.nextLine(), inputStream.nextLine());
        drawBoard(inputStream.nextLine(), inputStream.nextLine());
    }

    private static void drawBoard(String description, String coordinates) {
        System.out.println(description);
        Chess board = new Chess(coordinates);
        board.play();
        System.out.print('\n');
    }
}
