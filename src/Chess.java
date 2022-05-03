import java.util.HashMap;

public class Chess {
    public static void main(String[] args) {

        String[][] chessBoard = new String[8][8];
        int letter = 65; //"A" in ASCII code
        int number = 8;

        for (int i = 0; i < chessBoard.length; i++) {

            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = Character.toString(letter).toLowerCase().concat(Integer.toString(number));
                letter++;
            }
            letter = 65;
            number--;
        }
        System.out.println(knight("a1", "b2"));
    }

    public static int knight(String start, String finish) {
        // Your code here!
        String[] algebraicCoordinates = start.split("");
        char letter = 'a';
        int steps = 0;

        /*
         *The algebraic coordinates in the String[] form of "a1" or "d7" changed into
         *  "7,0" or "1,3" respectively in the two for-loops below
         */

        for (int i = 0; i < 8; i++) {
            if (String.valueOf(letter).equals(algebraicCoordinates[0])) {
                algebraicCoordinates[0] = Integer.toString(i);
                break;
            }
            letter++;
        }

        for (int i = 0, j = 7; i < 8 && j >= 0; i++, j--) {
            if (algebraicCoordinates[1].equals(Integer.toString(i))) {
                algebraicCoordinates[1] = Integer.toString(j);
            }
        }


        switch (moveNumber) {
            case 1:


        }


        return steps;


        return start.equals(finish) ? 0 : steps;
    }

    public static int basicMove(String start, int moveNumber, int[][] chessBoard) {

        return 1;

    }
}